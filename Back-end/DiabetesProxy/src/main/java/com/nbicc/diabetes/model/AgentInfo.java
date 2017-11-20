package com.nbicc.diabetes.model;

public class AgentInfo extends CloudEntity{

    private String agentName;

    private String agentPsw;

    private Integer isActive;

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentPsw() {
        return agentPsw;
    }

    public void setAgentPsw(String agentPsw) {
        this.agentPsw = agentPsw == null ? null : agentPsw.trim();
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}