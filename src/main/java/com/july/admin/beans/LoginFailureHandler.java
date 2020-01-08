package com.july.admin.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.july.admin.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author july
 * 登录失败的处理器
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException, ServletException {
        logger.error("onAuthenticationFailure=>");
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType("application/json;charset=utf-8");

        PrintWriter out = httpServletResponse.getWriter();
        Result result;
        if (authenticationException instanceof UsernameNotFoundException
                || authenticationException instanceof BadCredentialsException) {
            result = Result.fail("用户名或密码错误");
        } else if (authenticationException instanceof DisabledException) {
            result = Result.fail("账户被禁用");
        } else {
            result = Result.fail("登录失败!");
        }
        logger.error("onAuthenticationFailure=>authenticationException: " + authenticationException.getMessage());
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}