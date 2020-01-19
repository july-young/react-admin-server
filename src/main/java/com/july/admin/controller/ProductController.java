package com.july.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.july.admin.beans.ReactAdminAccessDecisionManager;
import com.july.admin.bo.ProductBO;
import com.july.admin.common.Result;
import com.july.admin.enums.ProductStatusEnum;
import com.july.admin.exception.ReactAdminBizException;
import com.july.admin.form.ProductAddForm;
import com.july.admin.form.ProductUpdateForm;
import com.july.admin.query.ProductQuery;
import com.july.admin.service.ProductService;
import com.july.admin.util.EnumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: july
 * @date: 2020/1/17 00:10
 * @description:
 */
@Controller
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    @ResponseBody
    public Result query(ProductQuery query) throws JsonProcessingException {

        logger.info("query=>query : "+new ObjectMapper().writeValueAsString(query));

        query.check();

        PageInfo<ProductBO> pageInfo = productService.query(query);

        return Result.success(pageInfo);
    }

    @PostMapping("product")
    @ResponseBody
    public Result<ProductBO> add(@RequestBody ProductAddForm form) throws JsonProcessingException {

        logger.info("add=>form : "+new ObjectMapper().writeValueAsString(form));

        ProductBO productBO = productService.add(form.toBO());

        return Result.success(productBO);
    }

    @PutMapping("product")
    @ResponseBody
    public Result<ProductBO> update(@RequestBody ProductUpdateForm form) throws JsonProcessingException {

        logger.info("update=>form : "+new ObjectMapper().writeValueAsString(form));

        ProductBO productBO = productService.add(form.toBO());

        return Result.success(productBO);
    }

    /**
     * 上架/下架
     * @param id
     * @param status
     * @return
     */
    @PostMapping("product/updateStatus")
    @ResponseBody
    public Result<ProductBO> updateStatus(Long id,Integer status){
        logger.info("updateStatus=>id : "+id +"status : " +status);

        if(id ==null){
            throw new ReactAdminBizException("id 不能为空！");
        }
        ProductStatusEnum productStatusEnum = EnumUtil.getEnum(ProductStatusEnum.class, status);

        if(productStatusEnum==null){
            throw  new ReactAdminBizException("状态值无效！");
        }

        productService.updateStatus(id,productStatusEnum);

        return Result.success();
    }

}
