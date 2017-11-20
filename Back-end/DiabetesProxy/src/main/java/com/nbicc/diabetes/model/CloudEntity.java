package com.nbicc.diabetes.model;


import com.nbicc.diabetes.utils.IdGen;

import java.io.Serializable;
import java.util.Date;

public class CloudEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    private String delFlag;
    
    public void preInsert(){
    	id = IdGen.uuid();
    	Date now = new Date();
    	createdAt = now;
    	updatedAt = now;
    	createdBy = id;
    	updatedBy = id;
    	delFlag = "0";
    }

    public void preInsert(String operatorId){
    	id = IdGen.uuid();
    	Date now = new Date();
    	createdAt = now;
    	updatedAt = now;
    	createdBy = operatorId;
    	updatedBy = operatorId;
    	delFlag = "0";
    }
    
    public void preUpdate(){
    	updatedAt = new Date();
    }
    
    public void preUpdate(String operatorId){
    	updatedAt = new Date();
    	updatedBy = operatorId;
    }
    
    public void preDelete(){
    	updatedAt = new Date();
    	delFlag = "1";
    }
    
    public void preDelete(String operatorId){
    	updatedAt = new Date();
    	updatedBy = operatorId;
    	delFlag = "1";
    }

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
