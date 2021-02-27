package com.ychhh.edu_management_system.utils;

public class ResponseException extends RuntimeException {

    public ResponseException(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }
    public ResponseException(String msg) {
        super(msg);
        this.code = 400;
        this.reason = msg;
    }

    public ResponseException(int code, String reason, Throwable cause) {
        super(reason, cause);
        this.code = code;
        this.reason = reason;
    }

    public ResponseException(int code, String reason, Object data) {
        super(reason);
        this.code = code;
        this.reason = reason;
        this.data = data;
    }
    private int code;
    private String reason;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static ResponseException myException(int code, String message){
        return new ResponseException(code, message, null);
    }

    public static ResponseException myException(int code, String message, Object data){
        return new ResponseException(code, message, data);
    }
}
