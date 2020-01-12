package com.july.admin.common;

import java.io.Serializable;

/**
 * @author: july
 * @date: 2020/1/8 22:02
 * @description:
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    private String msg;

    private T data;


    public Result(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, T data) {
        this.status = code;
        this.data = data;
    }

    public Result() {
    }

    public static Result success() {
        return new Result(0, "OK");
    }

    public static <T> Result<T> success(T data) {
        return new Result(0, data);
    }

    public static  Result success(String msg) {
        return new Result(0, msg,null);
    }

    public static <T> Result<T> success(T data,String msg) {
        return new Result(0, msg,data);
    }

    public static Result fail() {
        return new Result(1, "FAIL");
    }

    public static <T> Result<T> fail(T data) {
        return new Result(1, data);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(1, msg,null);
    }

    public static <T> Result<T> fail(int status,String msg) {
        return new Result(status, msg,null);
    }

    public int getStatus() {
        return status;
    }

    public void setState(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
