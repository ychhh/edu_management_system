package com.ychhh.edu_management_system.service.impl;

import com.ychhh.edu_management_system.dao.SysUserDao;
import com.ychhh.edu_management_system.entity.SysUser;
import com.ychhh.edu_management_system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        return sysUserDao.insert(sysUser);
    }

    @Override
    public int insertSelective(SysUser sysUser) {
        return sysUserDao.insert(sysUser);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sysUserDao.selectByPrimaryKey(id);
    }

    @Override
    public SysUser selectByName(String username) {
        return sysUserDao.selectByUserName(username);
    }

    @Override
    public List<SysUser> selectAll() {
        return sysUserDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser sysUser) {
        return sysUserDao.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int updateByPrimaryKey(SysUser sysUser) {
        return sysUserDao.updateByPrimaryKey(sysUser);
    }
}
