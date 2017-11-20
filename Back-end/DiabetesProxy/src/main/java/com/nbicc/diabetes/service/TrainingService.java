package com.nbicc.diabetes.service;

import com.alibaba.fastjson.JSONObject;
import com.nbicc.diabetes.mapper.TrainingInfoMapper;
import com.nbicc.diabetes.model.TrainingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.nbicc.diabetes.utils.CommonUtils.date2String;
import static com.nbicc.diabetes.utils.CommonUtils.string2Date;
import static com.nbicc.diabetes.utils.ParamKey.*;

/**
 * Created by zhuolin on 2017/9/26.
 */

@Service
public class TrainingService {

    @Autowired
    private TrainingInfoMapper trainingInfoMapper;

    public void addTraining(String trainingName,String startTime,String endTime,String agentId){
        TrainingInfo training = new TrainingInfo();
        training.preInsert(ADMIN_NAME);
        training.setTrainingName(trainingName);
        training.setAgentId(agentId);
        training.setStartTime(string2Date(startTime));
        training.setEndTime(string2Date(endTime));
        trainingInfoMapper.insert(training);
    }

    public List<JSONObject> getAllTraining(){
        List<TrainingInfo> trainings = trainingInfoMapper.getAllTraining();
        List<JSONObject> datas = new ArrayList<JSONObject>();
        if(!CollectionUtils.isEmpty(trainings)){
            for(TrainingInfo info:trainings){
                JSONObject item = new JSONObject();
                item.put(TRAINING_ID,info.getId());
                item.put(TRAINING_NAME,info.getTrainingName());
                item.put(START_TIME,date2String(info.getStartTime()));
                item.put(END_TIME,date2String(info.getEndTime()));
                item.put(AGENT_ID,info.getAgentId());
                item.put(AGENT_NAME,info.getAgentName());
                datas.add(item);
            }
        }
        return datas;
    }

    public boolean editTraining(String trainingId,String trainingName,String startTime,String endTime,String agentId){
        TrainingInfo training = trainingInfoMapper.selectByPrimaryKey(trainingId);
        if(training == null){
            return false;
        }
        training.preUpdate(ADMIN_NAME);
        if(trainingName != null){
            training.setTrainingName(trainingName);
        }
        if(startTime != null){
            training.setStartTime(string2Date(startTime));
        }
        if(endTime != null){
            training.setEndTime(string2Date(endTime));
        }
        if(agentId != null){
            training.setAgentId(agentId);
        }
        trainingInfoMapper.updateByPrimaryKey(training);
        return true;
    }

    public boolean deleteTraining(String trainingId){
        TrainingInfo training = trainingInfoMapper.selectByPrimaryKey(trainingId);
        if(training == null){
            return false;
        }
        training.preUpdate(ADMIN_NAME);
        training.setDelFlag("1");
        trainingInfoMapper.updateByPrimaryKey(training);
        return true;
    }


}
