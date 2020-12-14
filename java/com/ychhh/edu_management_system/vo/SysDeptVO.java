package com.ychhh.edu_management_system.vo;

import lombok.Data;

@Data
public class SysDeptVO {
    private Long id;

    private String name;

    private String level;

    private String remark;

    private Long parentId;
}
