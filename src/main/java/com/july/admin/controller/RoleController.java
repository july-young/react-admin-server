package com.july.admin.controller;

import com.july.admin.bo.RoleBO;
import com.july.admin.common.Page;
import com.july.admin.common.Result;
import com.july.admin.form.RoleAddForm;
import com.july.admin.form.RoleUpdateForm;
import com.july.admin.query.RoleQuery;
import com.july.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: july
 * @date: 2020/1/31 08:28
 * @description:
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("roles")
    @ResponseBody
    public Result menu(RoleQuery query){

        Page page = roleService.query(query);

        return Result.success(page);
    }

    @GetMapping("role")
    @ResponseBody
    public Result find(Long id){

        RoleBO roleBO = roleService.find(id);

        return Result.success(roleBO);
    }

    @PostMapping("role")
    @ResponseBody
    public Result create(@RequestBody RoleAddForm form){

        RoleBO roleBO = roleService.create(form.toBO());

        return Result.success(roleBO);
    }

    @PutMapping("role")
    @ResponseBody
    public Result update(@RequestBody RoleUpdateForm form){

        RoleBO roleBO = roleService.update(form.toBO());

        return Result.success(roleBO);
    }

    @DeleteMapping("role")
    @ResponseBody
    public Result remove(Long id){

        Integer res = roleService.remove(id);

        return Result.success(res);
    }


}
