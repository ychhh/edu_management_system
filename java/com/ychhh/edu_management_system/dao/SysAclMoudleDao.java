package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysAclMoudle;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface SysAclMoudleDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysAclMoudle record);

    int insertSelective(SysAclMoudle record);

    SysAclMoudle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAclMoudle record);

    int updateByPrimaryKey(SysAclMoudle record);
}