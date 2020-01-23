package com.july.admin.config;

import com.july.admin.common.Result;
import com.july.admin.exception.ReactAdminBizException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: july
 * @date: 2020/1/21 21:11
 * @description:
 */
@ControllerAdvice //该注解定义全局异常处理类
//@ControllerAdvice(basePackages ="com.july.admin.controller") 可指定包
@ResponseBody
public class GlobalExceptionConfig {
    /**
     * 该注解声明异常处理方法
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        //对于自定义异常的处理
        if(e instanceof ReactAdminBizException) {
            ReactAdminBizException ex = (ReactAdminBizException)e;
            return Result.fail(ex.getMessage());
            //对于绑定异常的处理，使用jsr303中的自定义注解抛出的异常属于绑定异常
        }else if(e instanceof BindException) {
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.fail(msg);
        }else {
            return Result.fail(e.getMessage());
        }
    }
}