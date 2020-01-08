package com.july.admin.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.july.admin.bo.UserBO;
import com.july.admin.common.Result;
import com.july.admin.converter.UserConverter;
import com.july.admin.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        logger.info("onAuthenticationSuccess=>");
        resp.setStatus(HttpStatus.OK.value());
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter  out = resp.getWriter();
        if(authentication.getPrincipal() instanceof UserBO){
            Result<UserVO> result = Result.success(UserConverter.toVo((UserBO) authentication.getPrincipal()));
            out.write(new ObjectMapper().writeValueAsString(result));
        }
        out.flush();
        out.close();
    }
}