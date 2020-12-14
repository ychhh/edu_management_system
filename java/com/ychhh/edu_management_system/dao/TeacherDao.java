package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface TeacherDao {
    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}