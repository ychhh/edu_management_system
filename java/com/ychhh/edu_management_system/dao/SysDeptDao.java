package com.ychhh.edu_management_system.dao;


import com.ychhh.edu_management_system.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface SysDeptDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    List<SysDept> selectByParentId(Long parentId);

    List<SysDept> selectAll();

    List<SysDept> selectByParentIdAndName(Long parentId,String name);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}