package com.july.admin.common;

/**
 * @author: july
 * @date: 2020/1/8 22:02
 * @description:
 */
public class Result<T> {

    private String code;

    private String msg;

    private T data;


    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result() {
    }

    public static Result success() {
        return new Result("1", "OK");
    }

    public static <T> Result<T> success(T data) {
        return new Result("1", data);
    }

    public static  Result success(String msg) {
        return new Result("1", msg,null);
    }

    public static <T> Result<T> success(T data,String msg) {
        return new Result("1", msg,data);
    }

    public static Result fail() {
        return new Result("0", "FAIL");
    }

    public static <T> Result<T> fail(T data) {
        return new Result("0", data);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result("0", msg,null);
    }
}
