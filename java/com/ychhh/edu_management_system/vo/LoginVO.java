package com.ychhh.edu_management_system.vo;

import lombok.Data;

@Data
public class LoginVO {
    //    private Long customerId;
    private Object token;
    //验证是否成功
    private  boolean judge;

    @Override
    public String toString() {
        return "LoginVO{" +
                "token=" + token.toString() +
                ", judge=" + judge +
                '}';
    }
}
