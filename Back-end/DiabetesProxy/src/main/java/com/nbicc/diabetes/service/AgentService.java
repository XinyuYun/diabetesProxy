package com.nbicc.diabetes.service;

import com.alibaba.fastjson.JSONObject;
import com.nbicc.diabetes.mapper.AgentInfoMapper;
import com.nbicc.diabetes.mapper.TrainingInfoMapper;
import com.nbicc.diabetes.model.AgentInfo;
import com.nbicc.diabetes.model.TrainingInfo;
import com.nbicc.diabetes.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.nbicc.diabetes.utils.CommonUtils.date2String;
import static com.nbicc.diabetes.utils.ParamKey.*;

/**
 * Created by zhuolin on 2017/9/26.
 */

@Service
public class AgentService {

    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Autowired
    private TrainingInfoMapper trainingInfoMapper;

    public AgentInfo login(String userName,String psw){
        AgentInfo agent = agentInfoMapper.getByAgentName(userName);
        if(agent == null || !CommonUtils.pswCompare(psw,agent.getAgentPsw())){
            return null;
        }
        return agent;
    }

    public List<JSONObject> getAllTrainingByAgentId(String agentId){
        List<TrainingInfo> trainings = trainingInfoMapper.getAllTrainingByAgentId(agentId);
        List<JSONObject> datas = new ArrayList<JSONObject>();
        if(!CollectionUtils.isEmpty(trainings)){
            for(TrainingInfo info:trainings){
                JSONObject item = new JSONObject();
                item.put(TRAINING_ID,info.getId());
                item.put(TRAINING_NAME,info.getTrainingName());
                item.put(START_TIME,date2String(info.getStartTime()));
                item.put(END_TIME,date2String(info.getEndTime()));
                datas.add(item);
            }
        }
        return datas;
    }
}
