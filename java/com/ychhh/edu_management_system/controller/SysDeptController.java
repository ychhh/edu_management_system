package com.ychhh.edu_management_system.controller;

import com.ychhh.edu_management_system.dto.SysDeptDTO;
import com.ychhh.edu_management_system.entity.FileRecord;
import com.ychhh.edu_management_system.entity.SysDept;
import com.ychhh.edu_management_system.service.SysDeptService;
import com.ychhh.edu_management_system.utils.ResponseException;
import com.ychhh.edu_management_system.utils.ResponseMessage;
import com.ychhh.edu_management_system.vo.SysDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@ControllerAdvice
public class SysDeptController {
    @Autowired
    SysDeptService sysDeptService;

    @GetMapping("/select/{id}")
    public ResponseMessage select(@PathVariable("id") Long id){
        SysDept sysDept =sysDeptService.selectByPrimaryKey(id);
        return ResponseMessage.success(sysDept);
    }
    @GetMapping("/gettree")
    public ResponseMessage getTree(){
        SysDeptDTO sysDeptDTO =sysDeptService.getTree();
        return ResponseMessage.success(sysDeptDTO);
    }
    @GetMapping("/delete/{id}")
    public ResponseMessage delete(@PathVariable("id") Long id){
        sysDeptService.deleteByPrimaryKey(id);
        return ResponseMessage.success();
    }
    @PostMapping("/save")
    public ResponseMessage save(@RequestBody SysDeptVO sysDept, HttpServletRequest request) {
        sysDeptService.insert(sysDept,request);
        return ResponseMessage.success();
    }
    @PostMapping("/update")
    public ResponseMessage update(@RequestBody SysDeptVO sysDept, HttpServletRequest request) {
        sysDeptService.updateByPrimaryKey(sysDept,request);
        return ResponseMessage.success();
    }

}
