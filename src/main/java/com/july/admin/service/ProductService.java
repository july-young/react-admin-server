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

    /**
     * 查询
     * @param productQuery
     * @return
     */
    PageInfo<ProductBO> query(ProductQuery productQuery);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    ProductBO find(Long id);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer remove(Long id);

    /**
     * 更新
     * @param bo
     * @return
     */
    ProductBO update(ProductBO bo);

    /**
     * 添加
     * @param bo
     * @return
     */
    ProductBO add(ProductBO bo);

    /**
     * 上架/下架
     * @param id
     * @param productStatusEnum
     * @return
     */
    int updateStatus(Long id, ProductStatusEnum productStatusEnum);
}
