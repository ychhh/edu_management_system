package com.ychhh.edu_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PageController {
    @GetMapping("/test")
    public ModelAndView test(HttpServletRequest request) {
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/adminAddCourse")
    public ModelAndView addCourse() {
        return new ModelAndView("admin/addCourse");
    }

    @GetMapping("/adminAddStudent")
    public ModelAndView addStudent() {
        return new ModelAndView("admin/addStudent");
    }

    @GetMapping("/adminShowTeacher")
    public ModelAndView showTeacher() {
        return new ModelAndView("admin/showTeacher");
    }

    @GetMapping("/adminUserPasswordRest")
    public ModelAndView userPasswordRest() {
        return new ModelAndView("admin/userPasswordRest");
    }

    @GetMapping("/adminPasswordRest")
    public ModelAndView passwordRest() {
        return new ModelAndView("admin/passwordRest");
    }
}
