package com.ychhh.edu_management_system.entity;

import com.ychhh.edu_management_system.vo.SysDeptVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * sys_dept
 * @author 
 */
@Data
public class SysDept implements Serializable {
    private Long id;

    private String name;

    private String level;

    private Integer seq;

    private String remark;

    private Long parentId;

    private String operator;

    private Date operateTime;

    private String operateIp;


    private static final long serialVersionUID = 1L;

    public static SysDept getSysDept(SysDeptVO sysDeptVO){
        SysDept sysDept=new SysDept();
        BeanUtils.copyProperties(sysDeptVO,sysDept);
        return sysDept;
    }
}