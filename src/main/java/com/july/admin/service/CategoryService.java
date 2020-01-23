package com.july.admin.service;

import com.github.pagehelper.PageInfo;
import com.july.admin.bo.CategoryBO;
import com.july.admin.dto.CategoryTreeDTO;
import com.july.admin.query.CategoryQuery;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/14 00:05
 * @description:
 */
public interface CategoryService {

    PageInfo<CategoryBO> query(CategoryQuery categoryQuery);

    Integer remove(Long id);

    CategoryBO update(CategoryBO bo);

    CategoryBO add(CategoryBO bo);

    /**
     * 获取所有的父级
     *
     * @param id
     */
    List<CategoryBO> findParents(Long id);

    List<CategoryTreeDTO> findCategoryOptions(Long id);
}
