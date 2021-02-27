package com.ychhh.edu_management_system.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * course
 * @author 
 */
@Data
public class Course implements Serializable {
    private Long id;

    private String name;

    private Integer type;

    private Integer status;

    private Long creater;

    private static final long serialVersionUID = 1L;
}