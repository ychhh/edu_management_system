package com.ychhh.edu_management_system.controller;

import com.ychhh.edu_management_system.entity.FileRecord;
import com.ychhh.edu_management_system.service.FileRecrodService;
import com.ychhh.edu_management_system.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filerecord")
public class FileRecordController {
    @Autowired
    FileRecrodService fileRecrodService;

    @GetMapping("/select/{cid}")
    public ResponseMessage find(@PathVariable("cid") Long cid){
        List<FileRecord> fileRecords =fileRecrodService.selectAllByCid(cid);
        return ResponseMessage.success(fileRecords);
    }
    @PostMapping("/save")
    public ResponseMessage save(@RequestBody FileRecord fileRecord){
        fileRecrodService.insert(fileRecord);
        return ResponseMessage.success();
    }
}
