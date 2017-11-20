package com.nbicc.diabetes.mapper;

import com.nbicc.diabetes.model.AgentInfo;

import java.util.List;

public interface AgentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AgentInfo record);

    int insertSelective(AgentInfo record);

    AgentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AgentInfo record);

    int updateByPrimaryKey(AgentInfo record);

    AgentInfo getByAgentName(String agentName);

    List<AgentInfo> getAllAgent();
}