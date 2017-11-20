package com.nbicc.diabetes.mapper;

import com.nbicc.diabetes.model.StudentInfo;

import java.util.List;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);

    List<StudentInfo> getStudentsByTrainingId(String trainingId);
}