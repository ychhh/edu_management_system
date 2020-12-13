package com.ychhh.edu_management_system.service.impl;

import com.ychhh.edu_management_system.service.FileService;
import com.ychhh.edu_management_system.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public boolean upload(MultipartFile file) {
        boolean f= FileUtil.upload(file);
        return f;
    }
}
