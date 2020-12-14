package com.ychhh.edu_management_system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_acl_log
 * @author 
 */
@Data
public class SysRoleAcl implements Serializable {
    private Long id;

    private Long targerId;

    private String oldValue;

    private Integer seq;

    private String remark;

    private Long parentId;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private Byte status;

    private Byte type;

    private String newValue;

    private static final long serialVersionUID = 1L;
}