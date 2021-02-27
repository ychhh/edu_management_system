package com.ychhh.edu_management_system.constants;

/**
 * 正则
 */
public interface Regexes {

    /**手机号*/
    String MOBILE = "((13[0-9])|(14[5,6,7,8,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}";

    /**用户名(字母数字下划线)*/
    String USERNAME = "[a-zA-Z0-9_]{6,20}";

    /**
     * 密码
     */
//    String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{6,16}$";
    String PASSWORD = "[a-zA-Z0-9_]{6,20}";
    /**
     * 电子邮件
     */
    String EMAIL = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}";
    
    String PRICE = "^[+]{0,1}(\\d+)$|^[+]{0,1}(\\d+\\.\\d+)$";
}
