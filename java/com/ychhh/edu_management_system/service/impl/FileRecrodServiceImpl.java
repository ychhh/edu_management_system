package com.ychhh.edu_management_system.service.impl;

import com.ychhh.edu_management_system.dao.FileRecordDao;
import com.ychhh.edu_management_system.entity.FileRecord;
import com.ychhh.edu_management_system.service.FileRecrodService;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileRecrodServiceImpl implements FileRecrodService {
    @Autowired
    FileRecordDao fileRecordDao;

    public void insert(FileRecord fileRecord){
        fileRecordDao.insert(fileRecord);
    }
    public FileRecord selectById(long id){
        return fileRecordDao.selectByPrimaryKey(id);
    }
    public List<FileRecord> selectAllByCid(long cid){
        return fileRecordDao.selectAllByCid(cid);
    }
}
