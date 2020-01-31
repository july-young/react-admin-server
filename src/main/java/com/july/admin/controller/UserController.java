package com.july.admin.controller;

import com.july.admin.bo.UserBO;
import com.july.admin.common.Page;
import com.july.admin.common.Result;
import com.july.admin.dto.UserWithRolesDTO;
import com.july.admin.exception.ReactAdminBizException;
import com.july.admin.form.UserAddForm;
import com.july.admin.form.UserUpdateForm;
import com.july.admin.query.UserQuery;
import com.july.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: july
 * @date: 2020/1/31 16:05
 * @description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    @ResponseBody
    public Result users(UserQuery query) {
        Page<UserWithRolesDTO> page = userService.query(query);

        return Result.success(page);
    }

    @GetMapping("user")
    @ResponseBody
    public Result find(Long id) {
        UserBO userBO = userService.find(id);
        return Result.success(userBO);
    }

    @PostMapping("user")
    @ResponseBody
    public Result create(@RequestBody UserAddForm form) {
        Integer res = userService.create(form.toBO());
        return Result.success(res);
    }

    @PutMapping("user")
    @ResponseBody
    public Result update(@RequestBody UserUpdateForm form) {
        Integer res =  userService.update(form.toBO());
        return Result.success(res);
    }

    @DeleteMapping("user")
    @ResponseBody
    public Result remove(Long id) {
        if(id==null){
            throw new ReactAdminBizException("id不能为空！");
        }
        Integer res = userService.remove(id);
        return Result.success(res);
    }
}
