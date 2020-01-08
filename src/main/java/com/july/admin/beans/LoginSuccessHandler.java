package com.july.admin.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse resp, Authentication authException) throws IOException, ServletException {
        resp.setStatus(HttpStatus.OK.value());
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<>();
        if (authException instanceof InsufficientAuthenticationException) {
            map.put("msg","请求失败，请联系管理员！");
            map.put("status","0");
        }else{
            map.put("msg","登录成功！");
            map.put("status","1");
        }
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();
    }
}