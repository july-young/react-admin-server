package com.july.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.july.admin.beans.ReactAdminAccessDecisionManager;
import com.july.admin.bo.ProductBO;
import com.july.admin.common.Result;
import com.july.admin.query.ProductQuery;
import com.july.admin.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

        return Result.success(pageInfo.getList());
    }

}
