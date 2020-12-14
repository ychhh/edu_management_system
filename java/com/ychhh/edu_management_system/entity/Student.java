package com.ychhh.edu_management_system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Long id;

    private String name;

    private Byte sex;

    private Long deptId;

    private Byte status;

    private String password;

    private String salt;

    private String people;

    private String mail;

    private String phone;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}