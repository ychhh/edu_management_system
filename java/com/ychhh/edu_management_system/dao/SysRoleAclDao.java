package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysRoleAcl;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface SysRoleAclDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleAcl record);

    int insertSelective(SysRoleAcl record);

    SysRoleAcl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleAcl record);

    int updateByPrimaryKey(SysRoleAcl record);
}