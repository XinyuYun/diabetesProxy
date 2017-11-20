package com.nbicc.diabetes.model;

import java.util.Date;

public class TrackingInfo extends CloudEntity{

    private Date trackingDate;

    private Integer trackingType;

    private String dietRecommend;

    private String sportRecommend;

    private String insulinDosageRecommend;

    private String studentId;

    private String bloodSugar;

    public String getInsulinDosageRecommend() {
        return insulinDosageRecommend;
    }

    public void setInsulinDosageRecommend(String insulinDosageRecommend) {
        this.insulinDosageRecommend = insulinDosageRecommend;
    }

    public Date getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(Date trackingDate) {
        this.trackingDate = trackingDate;
    }

    public Integer getTrackingType() {
        return trackingType;
    }

    public void setTrackingType(Integer trackingType) {
        this.trackingType = trackingType;
    }

    public String getDietRecommend() {
        return dietRecommend;
    }

    public void setDietRecommend(String dietRecommend) {
        this.dietRecommend = dietRecommend == null ? null : dietRecommend.trim();
    }

    public String getSportRecommend() {
        return sportRecommend;
    }

    public void setSportRecommend(String sportRecommend) {
        this.sportRecommend = sportRecommend == null ? null : sportRecommend.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(String bloodSugar) {
        this.bloodSugar = bloodSugar == null ? null : bloodSugar.trim();
    }

}