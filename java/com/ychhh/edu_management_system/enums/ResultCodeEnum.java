package com.ychhh.edu_management_system.enums;


public enum ResultCodeEnum {

    /******************** 公共 ********************/
    /**
     * 系统异常异常
     */
    OK(1, "正常返回"),
    /**
     * 系统异常异常
     */
    SERVER_ERROR(500, "服务器异常"),
    /**
     * 请求参数异常
     */
    PARAM_ERROR(400, "参数异常"),
    /**
     * 请求参数异常
     */
    NET_ERROR(600, "网络异常"),

    Redirect_ERROR(302, "授权过期，重新登录"),

    USER_TOKEN_EXPIRED(10000,"登录状态失效，请重新登录")
    ;
    private int code;
    private String desc;

    private ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
