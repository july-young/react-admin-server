package com.july.admin.exception;

/**
 * @author: july
 * @date: 2020/1/15 22:50
 * @description:
 */
public class ReactAdminException extends RuntimeException {

    private int code;

    public ReactAdminException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public ReactAdminException(ReactAdminExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode() ,exceptionEnum.getMsg());
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
