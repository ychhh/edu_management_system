package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysAclLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface SysAclLogDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysAclLog record);

    int insertSelective(SysAclLog record);

    SysAclLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAclLog record);

    int updateByPrimaryKey(SysAclLog record);
}