package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface StudentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}