package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Long id);

    int insert(Course course);

    int insertSelective(Course course);

    Course selectByPrimaryKey(Long id);

    List<Course> selectByStatus(Long creater,Integer status);

    int updateByPrimaryKeySelective(Course course);

    int updateByPrimaryKey(Course course);
}