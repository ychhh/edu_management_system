package com.ychhh.edu_management_system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_acl
 * @author 
 */
@Data
public class SysAcl implements Serializable {
    private Long id;

    private String name;

    private String level;

    private Integer seq;

    private String remark;

    private Long parentId;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private Byte status;

    private Integer code;

    private Long aclMoudleId;

    private String url;

    private Integer type;

    private static final long serialVersionUID = 1L;
}