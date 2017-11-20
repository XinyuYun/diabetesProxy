package com.nbicc.diabetes.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nbicc.diabetes.mapper.StudentInfoMapper;
import com.nbicc.diabetes.mapper.TrackingInfoMapper;
import com.nbicc.diabetes.model.StudentInfo;
import com.nbicc.diabetes.model.TrackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nbicc.diabetes.utils.CommonUtils.date2String;
import static com.nbicc.diabetes.utils.CommonUtils.string2Date;
import static com.nbicc.diabetes.utils.ParamKey.*;

/**
 * Created by zhuolin on 2017/9/27.
 */

@Service
public class StudentService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Autowired
    private TrackingInfoMapper trackingInfoMapper;

    public void addStudent(String trainingId,String studentName,Integer studentAge,String studentSex,String contactInfo,String diabetesYear,String insulinYear,String insulinType,String insulinDosage){
        StudentInfo student = new StudentInfo();
        student.preInsert(ADMIN_NAME);
        student.setTrainingId(trainingId);
        student.setStudentName(studentName);
        student.setStudentAge(studentAge);
        student.setStudentSex(studentSex);
        student.setContactInfo(contactInfo);
        student.setDiabetesYear(diabetesYear);
        student.setInsulinYear(insulinYear);
        student.setInsulinType(insulinType);
        student.setInsulinDosage(insulinDosage);
        studentInfoMapper.insert(student);
    }

    public boolean editStudent(String studentId,String studentName,Integer studentAge,String studentSex,String contactInfo,String diabetesYear,String insulinYear,String insulinType,String insulinDosage){
        StudentInfo student = studentInfoMapper.selectByPrimaryKey(studentId);
        if(student == null){
            return false;
        }
        student.preUpdate(ADMIN_NAME);
        if(studentName != null){
            student.setStudentName(studentName);
        }
        if(studentAge != null){
            student.setStudentAge(studentAge);
        }
        if(studentSex != null){
            student.setStudentSex(studentSex);
        }
        if(contactInfo != null){
            student.setContactInfo(contactInfo);
        }
        if(diabetesYear != null){
            student.setDiabetesYear(diabetesYear);
        }
        if(insulinYear != null){
            student.setInsulinYear(insulinYear);
        }
        if(insulinType != null){
            student.setInsulinType(insulinType);
        }
        if(insulinDosage != null){
            student.setInsulinDosage(insulinDosage);
        }
        studentInfoMapper.updateByPrimaryKey(student);
        return true;
    }

    public boolean deleteStudent(String studentId){
        StudentInfo student = studentInfoMapper.selectByPrimaryKey(studentId);
        if(student == null){
            return false;
        }
        student.preUpdate(ADMIN_NAME);
        student.setDelFlag("1");
        studentInfoMapper.updateByPrimaryKey(student);
        return true;
    }

    public List<JSONObject> getStudentsInfoByTrainingId(String trainingId){
        List<StudentInfo> students = studentInfoMapper.getStudentsByTrainingId(trainingId);
        List<JSONObject> datas = new ArrayList<JSONObject>();
        if(!CollectionUtils.isEmpty(students)){
            for(StudentInfo info:students){
                JSONObject item = new JSONObject();
                item.put(STUDENT_ID,info.getId());
                item.put(STUDENT_NAME,info.getStudentName());
                item.put(STUDENT_AGE,info.getStudentAge());
                item.put(STUDENT_SEX,info.getStudentSex());
                item.put(CONTACT_INFO,info.getContactInfo());
                item.put(DIABETES_YEAR,info.getDiabetesYear());
                item.put(INSULIN_YEAR,info.getInsulinYear());
                item.put(INSULIN_TYPE,info.getInsulinType());
                item.put(INSULIN_DOSAGE,info.getInsulinDosage());
                item.put(TRACKINGS,getTrackingsByStudentId(info.getId()));
                datas.add(item);
            }
        }
        return datas;
    }

    private JSONArray getTrackingsByStudentId(String studentId){
        List<TrackingInfo> trackingInfos = trackingInfoMapper.getTrackingInfoByStudentId(studentId);
        if(CollectionUtils.isEmpty(trackingInfos)){
            return null;
        }
        Map<String,JSONArray> map = new HashMap<String,JSONArray>();
        for(TrackingInfo info:trackingInfos){
            String trackingDate = date2String(info.getTrackingDate());
            if(map.containsKey(trackingDate)){
                JSONArray record = map.get(trackingDate);
                buildRecord(record,info);
            }else{
                JSONArray record = new JSONArray();
                buildRecord(record,info);
                map.put(trackingDate,record);
            }
        }
        JSONArray trackings = new JSONArray();
        for (Map.Entry<String,JSONArray> entry : map.entrySet()){
            JSONObject tracking = new JSONObject();
            tracking.put(TRACKING_DATE,entry.getKey());
            tracking.put(TRACKING_RECORD,entry.getValue());
            trackings.add(tracking);
        }
        return trackings;
    }

    private void buildRecord(JSONArray record,TrackingInfo info){
        JSONObject item = new JSONObject();
        item.put(TRACKING_TYPE,info.getTrackingType());
        item.put(TRACKING_ID,info.getId());
        item.put(DIET_RECOMMEND,info.getDietRecommend());
        item.put(SPORT_RECOMMEND,info.getSportRecommend());
        item.put(INSULIN_DOSAGE_RECOMMEND,info.getInsulinDosageRecommend());
        item.put(BLOOD_SUGAR,info.getBloodSugar());
        record.add(item);
    }

    public List<JSONObject> getStudentsInfoByTrainingId(String trainingId, String trackingDate, String trackingType){
        List<StudentInfo> students = studentInfoMapper.getStudentsByTrainingId(trainingId);
        List<JSONObject> datas = new ArrayList<JSONObject>();
        if(!CollectionUtils.isEmpty(students)){
            for(StudentInfo info:students){
                JSONObject item = new JSONObject();
                item.put(STUDENT_ID,info.getId());
                item.put(STUDENT_NAME,info.getStudentName());
                item.put(STUDENT_AGE,info.getStudentAge());
                item.put(STUDENT_SEX,info.getStudentSex());
                item.put(CONTACT_INFO,info.getContactInfo());
                item.put(DIABETES_YEAR,info.getDiabetesYear());
                item.put(INSULIN_YEAR,info.getInsulinYear());
                item.put(INSULIN_TYPE,info.getInsulinType());
                item.put(INSULIN_DOSAGE,info.getInsulinDosage());
                TrackingInfo trackingInfo = getByStudentId(info.getId(),trackingDate,Integer.parseInt(trackingType));
                if(trackingInfo != null){
                    item.put(DIET_RECOMMEND,trackingInfo.getDietRecommend());
                    item.put(SPORT_RECOMMEND,trackingInfo.getSportRecommend());
                    item.put(INSULIN_DOSAGE_RECOMMEND,trackingInfo.getInsulinDosageRecommend());
                    item.put(BLOOD_SUGAR,trackingInfo.getBloodSugar());
                    item.put(TRACKING_ID,trackingInfo.getId());
                }
                datas.add(item);
            }
        }
        return datas;
    }

    public TrackingInfo getByStudentId(String studentId,String trackingDate, Integer trackingType){
        TrackingInfo query = new TrackingInfo();
        query.setStudentId(studentId);
        query.setTrackingDate(string2Date(trackingDate));
        query.setTrackingType(trackingType);
        return trackingInfoMapper.getTrackingInfoByStudentIdAndDate(query);
    }

    public boolean editBloodSugar(String trackingId,String bloodSugar){
        TrackingInfo trackingInfo = trackingInfoMapper.selectByPrimaryKey(trackingId);
        if(trackingInfo == null){
            return false;
        }
        trackingInfo.preUpdate(ADMIN_NAME);
        trackingInfo.setBloodSugar(bloodSugar);
        trackingInfoMapper.updateByPrimaryKey(trackingInfo);
        return true;
    }
}
