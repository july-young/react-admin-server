package com.july.admin.service;

import com.github.pagehelper.PageInfo;
import com.july.admin.bo.CategoryBO;
import com.july.admin.bo.ProductBO;
import com.july.admin.enums.ProductStatusEnum;
import com.july.admin.query.CategoryQuery;
import com.july.admin.query.ProductQuery;

/**
 * @author: july
 * @date: 2020/1/14 00:05
 * @description:
 */
public interface ProductService {

    PageInfo<ProductBO> query(ProductQuery productQuery);

    Integer remove(Long id);

    ProductBO update(ProductBO bo);

    ProductBO add(ProductBO bo);

    int updateStatus(Long id, ProductStatusEnum productStatusEnum);
}
