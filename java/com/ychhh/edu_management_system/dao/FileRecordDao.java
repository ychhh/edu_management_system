package com.ychhh.edu_management_system.dao;

//import generate.FileRecord;

import com.ychhh.edu_management_system.entity.FileRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ychhh.edu_management_system.entity.FileRecord;

import java.util.List;

@Mapper
public interface FileRecordDao {
    int deleteByPrimaryKey(Long id);

    int insert(FileRecord record);

    int insertSelective(FileRecord record);

    FileRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileRecord record);

    int updateByPrimaryKey(FileRecord record);

    List<FileRecord> selectAllByCid(Long cid);
}