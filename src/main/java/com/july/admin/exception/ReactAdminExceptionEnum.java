package com.july.admin.exception;

/**
 * @author: july
 * @date: 2020/1/15 23:05
 * @description:
 */
public enum ReactAdminExceptionEnum {
    PARAM(1001,"参数错误!"),
    OTHER(9000,"other")

    ;
    private int code;
    private String msg;
    ReactAdminExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
