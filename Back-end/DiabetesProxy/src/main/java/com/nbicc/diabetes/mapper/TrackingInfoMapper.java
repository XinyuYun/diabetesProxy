package com.nbicc.diabetes.mapper;

import com.nbicc.diabetes.model.TrackingInfo;

import java.util.List;

public interface TrackingInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TrackingInfo record);

    TrackingInfo selectByPrimaryKey(String id);

    int updateByPrimaryKey(TrackingInfo record);

    TrackingInfo getTrackingInfoByStudentIdAndDate(TrackingInfo trackingInfo);

    List<TrackingInfo> getTrackingInfoByStudentId(String studentId);
}