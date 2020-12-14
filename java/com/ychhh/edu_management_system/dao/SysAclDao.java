package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysAcl;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface SysAclDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysAcl record);

    int insertSelective(SysAcl record);

    SysAcl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAcl record);

    int updateByPrimaryKey(SysAcl record);
}