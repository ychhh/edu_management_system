package com.ychhh.edu_management_system.service;

import com.ychhh.edu_management_system.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SysUserService {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser sysUser);

    int insertSelective(SysUser sysUser);

    SysUser selectByPrimaryKey(Long id);

    SysUser selectByName(String username);

    List<SysUser> selectAll();

    int updateByPrimaryKeySelective(SysUser sysUser);

    int updateByPrimaryKey(SysUser sysUser);


}