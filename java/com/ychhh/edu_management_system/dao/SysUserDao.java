package com.ychhh.edu_management_system.dao;

import com.ychhh.edu_management_system.entity.SysDept;
import com.ychhh.edu_management_system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser sysUser);

    int insertSelective(SysUser sysUser);

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> selectAll();

    SysUser selectByUserName(String username);

    int updateByPrimaryKeySelective(SysUser sysUser);

    int updateByPrimaryKey(SysUser sysUser);
}