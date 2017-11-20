package com.nbicc.diabetes.model;

public class StudentInfo extends CloudEntity{
    private String studentName;

    private Integer studentAge;

    private String studentSex;

    private String contactInfo;

    private String diabetesYear;

    private String insulinYear;

    private String insulinType;

    private String insulinDosage;

    private String trainingId;

//    private String dietRecommend;
//
//    private String sportRecommend;
//
//    private String bloodSugar;
//
//    private Date trackingDate;
//
//    private Integer trackingType;
//
//    private String trackingId;

//    public String getTrackingId() {
//        return trackingId;
//    }
//
//    public void setTrackingId(String trackingId) {
//        this.trackingId = trackingId;
//    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo == null ? null : contactInfo.trim();
    }

    public String getDiabetesYear() {
        return diabetesYear;
    }

    public void setDiabetesYear(String diabetesYear) {
        this.diabetesYear = diabetesYear == null ? null : diabetesYear.trim();
    }

    public String getInsulinYear() {
        return insulinYear;
    }

    public void setInsulinYear(String insulinYear) {
        this.insulinYear = insulinYear == null ? null : insulinYear.trim();
    }

    public String getInsulinType() {
        return insulinType;
    }

    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType == null ? null : insulinType.trim();
    }

    public String getInsulinDosage() {
        return insulinDosage;
    }

    public void setInsulinDosage(String insulinDosage) {
        this.insulinDosage = insulinDosage == null ? null : insulinDosage.trim();
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId == null ? null : trainingId.trim();
    }

//    public String getDietRecommend() {
//        return dietRecommend;
//    }
//
//    public void setDietRecommend(String dietRecommend) {
//        this.dietRecommend = dietRecommend;
//    }
//
//    public String getSportRecommend() {
//        return sportRecommend;
//    }
//
//    public void setSportRecommend(String sportRecommend) {
//        this.sportRecommend = sportRecommend;
//    }
//
//    public String getBloodSugar() {
//        return bloodSugar;
//    }
//
//    public void setBloodSugar(String bloodSugar) {
//        this.bloodSugar = bloodSugar;
//    }
//
//    public Date getTrackingDate() {
//        return trackingDate;
//    }
//
//    public void setTrackingDate(Date trackingDate) {
//        this.trackingDate = trackingDate;
//    }
//
//    public Integer getTrackingType() {
//        return trackingType;
//    }
//
//    public void setTrackingType(Integer trackingType) {
//        this.trackingType = trackingType;
//    }

}