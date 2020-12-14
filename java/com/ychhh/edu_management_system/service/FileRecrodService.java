package com.ychhh.edu_management_system.service;

import com.ychhh.edu_management_system.entity.FileRecord;

import java.util.List;

public interface FileRecrodService {
    void insert(FileRecord fileRecord);
    FileRecord selectById(long id);
    public List<FileRecord> selectAllByCid(long cid);
}
