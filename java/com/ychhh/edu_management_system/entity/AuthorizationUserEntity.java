package com.ychhh.edu_management_system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * token用户信息
 */
@Data
public class AuthorizationUserEntity implements Serializable {

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

    private Byte rank;

    private Byte type;


}
