package com.july.admin.exception;

/**
 * @author: july
 * @date: 2020/1/15 22:55
 * @description:
 */
public class ReactAdminBizException extends ReactAdminException{

    private ReactAdminBizException(int code, String msg) {
        super(code, msg);
    }

    public ReactAdminBizException(String msg){
        super(ReactAdminExceptionEnum.OTHER.getCode(),msg);
    }

}
