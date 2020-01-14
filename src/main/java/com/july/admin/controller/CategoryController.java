package com.july.admin.controller;

import com.github.pagehelper.PageInfo;
import com.july.admin.bo.CategoryBO;
import com.july.admin.common.Page;
import com.july.admin.common.Result;
import com.july.admin.form.CategoryAddFrom;
import com.july.admin.form.CategoryUpdateForm;
import com.july.admin.query.CategoryQuery;
import com.july.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author: july
 * @date: 2020/1/10 22:21
 * @description:
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    @ResponseBody
    public Result query(CategoryQuery categoryQuery) {

        PageInfo<CategoryBO> pageInfo = categoryService.query(categoryQuery);

        return Result.success(Page.getInstance(pageInfo));
    }

    @PostMapping("category")
    @ResponseBody
    public Result add(CategoryAddFrom form) {

        CategoryBO bo = categoryService.add(form.toBO());

        return Result.success(bo);
    }

    @PutMapping("category")
    @ResponseBody
    public Result update(CategoryUpdateForm form) {

        CategoryBO bo = categoryService.update(form.toBO());

        return Result.success(bo);
    }

    @DeleteMapping("category")
    @ResponseBody
    public Result remove(Long id) {

        Integer num = categoryService.remove(id);

        return Result.success(num);
    }
}
