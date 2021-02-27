package com.ychhh.edu_management_system.controller;

import com.ychhh.edu_management_system.entity.Course;
import com.ychhh.edu_management_system.entity.FileRecord;
import com.ychhh.edu_management_system.service.CourseService;
import com.ychhh.edu_management_system.service.FileRecrodService;
import com.ychhh.edu_management_system.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/create")
    public ResponseMessage save(@RequestBody Course course){
        courseService.createCourse(course);
        return ResponseMessage.success();
    }

    @GetMapping("/getApprovalCourseList")
    public ResponseMessage getApprovalCourseList(long creater,int status){
        List<Course> list=courseService.getApprovalCourseList(creater,status);
        return ResponseMessage.success(list);
    }
    @GetMapping("/approvalCourseList")
    public ResponseMessage approvalCourseList(List<Long> ids){
        courseService.approvalCourseList(ids,1);
        return ResponseMessage.success();
    }
    @GetMapping("/rejectCourseList")
    public ResponseMessage rejectCourseList(List<Long> ids){
        courseService.approvalCourseList(ids,2);
        return ResponseMessage.success();
    }
}
