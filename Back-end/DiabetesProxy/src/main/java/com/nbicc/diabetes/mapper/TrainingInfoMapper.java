package com.nbicc.diabetes.mapper;

import com.nbicc.diabetes.model.TrainingInfo;

import java.util.List;

public interface TrainingInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TrainingInfo record);

    int insertSelective(TrainingInfo record);

    TrainingInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TrainingInfo record);

    int updateByPrimaryKey(TrainingInfo record);

    List<TrainingInfo> getAllTraining();

    List<TrainingInfo> getAllTrainingByAgentId(String agentId);
}