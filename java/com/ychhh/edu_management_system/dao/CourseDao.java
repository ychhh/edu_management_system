package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}