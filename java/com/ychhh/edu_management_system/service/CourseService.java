package com.ychhh.edu_management_system.service;

import com.ychhh.edu_management_system.entity.Course;

import java.util.List;

public interface CourseService {
    //教师
    //申请开设新课程
    public void createCourse(Course course);
    //管理员和教师 查看课程审批情况
    public List<Course> getApprovalCourseList(long creater,int status);

    public void approvalCourseList(List<Long> ids,int status);

}
