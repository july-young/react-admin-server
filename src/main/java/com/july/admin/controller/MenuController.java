package com.july.admin.controller;

import com.july.admin.common.Result;
import com.july.admin.dto.PermissionTreeDTO;
import com.july.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
public class MenuController {

    @Autowired
    private PermissionService permissionService;
    @GetMapping("menu")
    @ResponseBody
    @Cacheable("menu")
    public Result menu(){

        List<PermissionTreeDTO> list =  permissionService.getPermissionsInTree();

        return Result.success(list);
    }
}
