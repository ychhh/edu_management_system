package com.ychhh.edu_management_system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * file_record
 * @author 
 */
@Data
public class FileRecord implements Serializable {
    private Long id;

    private String name;

    private Integer type;

    private Integer deleted;

    private Date createTime;

    private Integer downloadSum;

    private Long cid;

    private static final long serialVersionUID = 1L;
}