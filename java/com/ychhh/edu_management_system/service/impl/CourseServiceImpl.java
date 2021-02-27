package com.ychhh.edu_management_system.service.impl;

import com.ychhh.edu_management_system.dao.CourseDao;
import com.ychhh.edu_management_system.entity.Course;
import com.ychhh.edu_management_system.service.CourseService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Override
    public void createCourse(Course course) {
        courseDao.insert(course);
    }

    @Override
    @ApiImplicitParam(name="creater", value="创建者", required=false, paramType="query" ,allowMultiple=true, dataType = "long")
    public List<Course> getApprovalCourseList(long creater,int status) {
        List<Course> courses =courseDao.selectByStatus(creater,status);
        return courses;
    }

    @Override
    @ApiImplicitParam(name="ids", value="用户ID数组集", required=true, paramType="query" ,allowMultiple=true, dataType = "long")
    public void approvalCourseList(List<Long> ids,int status) {
        for (long id:ids){
            Course course=courseDao.selectByPrimaryKey(id);
            course.setStatus(status);
            courseDao.updateByPrimaryKeySelective(course);
        }
    }



}
