package com.july.admin.controller;

import com.july.admin.common.Result;
import com.july.admin.dto.PermissionTreeDTO;
import com.july.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/10 22:21
 * @description:
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String login(){

       return "index.html";
    }
}
