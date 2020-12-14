package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface SysRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}