package com.ychhh.edu_management_system.service;

import com.ychhh.edu_management_system.dto.SysDeptDTO;
import com.ychhh.edu_management_system.entity.SysDept;
import com.ychhh.edu_management_system.utils.ResponseException;
import com.ychhh.edu_management_system.vo.SysDeptVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SysDeptService {

    SysDeptDTO getTree();

    List<SysDept> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(SysDeptVO sysDeptVO, HttpServletRequest request) throws ResponseException;

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKey(SysDeptVO sysDeptVO, HttpServletRequest request) throws ResponseException;

}
