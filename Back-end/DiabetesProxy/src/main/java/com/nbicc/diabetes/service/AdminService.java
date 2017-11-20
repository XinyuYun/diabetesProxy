package com.nbicc.diabetes.service;

import com.alibaba.fastjson.JSONObject;
import com.nbicc.diabetes.mapper.AgentInfoMapper;
import com.nbicc.diabetes.mapper.StudentInfoMapper;
import com.nbicc.diabetes.mapper.TrackingInfoMapper;
import com.nbicc.diabetes.model.AgentInfo;
import com.nbicc.diabetes.model.StudentInfo;
import com.nbicc.diabetes.model.TrackingInfo;
import com.nbicc.diabetes.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.nbicc.diabetes.utils.CommonUtils.string2Date;
import static com.nbicc.diabetes.utils.ParamKey.*;

/**
 * Created by zhuolin on 2017/9/26.
 */

@Service
public class AdminService {

    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Autowired
    private TrackingInfoMapper trackingInfoMapper;

    @Autowired
    private StudentService studentService;

    public boolean login(String userName,String userPsw){
        return ADMIN_NAME.equals(userName) && ADMIN_PSW.equals(userPsw);
    }

    public boolean addAgent(String agentName,String agentPsw){
        AgentInfo agentInfo = agentInfoMapper.getByAgentName(agentName);
        if(agentInfo != null){
            return false;
        }
        agentInfo = new AgentInfo();
        agentInfo.preInsert(ADMIN_NAME);
        agentInfo.setAgentName(agentName);
        agentInfo.setAgentPsw(CommonUtils.encode(agentPsw));
        agentInfo.setIsActive(0);
        agentInfoMapper.insert(agentInfo);
        return true;
    }

    public boolean editAgent(String agentId,String agentPsw,Integer isActive){
        AgentInfo agentInfo = agentInfoMapper.selectByPrimaryKey(agentId);
        if(agentInfo == null){
            return false;
        }
        if(agentPsw != null){
            agentInfo.setAgentPsw(CommonUtils.encode(agentPsw));
        }
        if(isActive != null){
            agentInfo.setIsActive(isActive);
        }
        agentInfo.preUpdate(ADMIN_NAME);
        agentInfoMapper.updateByPrimaryKey(agentInfo);
        return true;
    }

    public boolean deleteAgent(String agentId){
        AgentInfo agentInfo = agentInfoMapper.selectByPrimaryKey(agentId);
        if(agentInfo == null){
            return false;
        }
        agentInfo.preUpdate(ADMIN_NAME);
        agentInfo.setDelFlag("1");
        agentInfoMapper.updateByPrimaryKey(agentInfo);
        return true;
    }

    public List<JSONObject> getAllAgent(){
        List<AgentInfo> agents = agentInfoMapper.getAllAgent();
        List<JSONObject> datas = new ArrayList<JSONObject>();
        if(!CollectionUtils.isEmpty(agents)){
            for(AgentInfo info:agents){
                JSONObject item = new JSONObject();
                item.put(AGENT_ID,info.getId());
                item.put(AGENT_NAME,info.getAgentName());
                item.put(IS_ACTIVE,info.getIsActive());
                datas.add(item);
            }
        }
        return datas;
    }

    public boolean addAdvice(String studentId,String trackingDate,Integer trackingType,String dietRecommend,String sportRecommend,String insulinRecommend){
        StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(studentId);
        if(studentInfo == null){
            return false;
        }
        TrackingInfo trackingInfo = studentService.getByStudentId(studentId,trackingDate,trackingType);
        if(trackingInfo != null){
            return false;
        }
        trackingInfo = new TrackingInfo();
        trackingInfo.preInsert(ADMIN_NAME);
        trackingInfo.setStudentId(studentId);
        trackingInfo.setTrackingDate(string2Date(trackingDate));
        trackingInfo.setTrackingType(trackingType);
        trackingInfo.setDietRecommend(dietRecommend);
        trackingInfo.setSportRecommend(sportRecommend);
        trackingInfo.setInsulinDosageRecommend(insulinRecommend);
        trackingInfoMapper.insert(trackingInfo);
        return true;
    }

    public boolean editAdvice(String trackingId,String trackingDate,Integer trackingType,String dietRecommend,String sportRecommend,String insulinRecommend){
        TrackingInfo trackingInfo = trackingInfoMapper.selectByPrimaryKey(trackingId);
        if(trackingInfo == null){
            return false;
        }
        trackingInfo.preUpdate(ADMIN_NAME);
        if(trackingDate != null){
            trackingInfo.setTrackingDate(string2Date(trackingDate));
        }
        if(trackingType != null){
            trackingInfo.setTrackingType(trackingType);
        }
        if(dietRecommend != null){
            trackingInfo.setDietRecommend(dietRecommend);
        }
        if(sportRecommend != null){
            trackingInfo.setSportRecommend(sportRecommend);
        }
        if(insulinRecommend != null){
            trackingInfo.setInsulinDosageRecommend(insulinRecommend);
        }
        trackingInfoMapper.updateByPrimaryKey(trackingInfo);
        return true;
    }
}
