package com.ychhh.edu_management_system.controller;

import com.ychhh.edu_management_system.service.FileService;
import com.ychhh.edu_management_system.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public void upload(MultipartFile file){
        boolean b = fileService.upload(file);
        System.out.println(b);
    }
    @GetMapping("/download")
    @ResponseBody
    public void upload(String filename, HttpServletResponse response) throws IOException {
        FileUtil.OSSDownload(filename,response);
    }
}
