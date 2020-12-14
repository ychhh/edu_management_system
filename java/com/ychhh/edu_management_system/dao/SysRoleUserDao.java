package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface SysRoleUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    SysRoleUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);
}