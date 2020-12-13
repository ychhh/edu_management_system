package com.ychhh.edu_management_system.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public boolean upload(MultipartFile file);
}
