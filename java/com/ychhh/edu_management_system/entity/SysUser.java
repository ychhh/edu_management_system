package com.ychhh.edu_management_system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Long id;

    private String name;

    private String username;

    private Byte sex;

    private Long deptId;

    private Byte status;

    private String password;

    private String salt;

    private String people;

    private String mail;

    private String phone;

    private Date createTime;

    private Byte rank;

    private Byte type;

    private static final long serialVersionUID = 1L;
}