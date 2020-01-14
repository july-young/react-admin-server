package com.july.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.july.admin.bo.CategoryBO;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.CategoryConverter;
import com.july.admin.dao.CategoryMapper;
import com.july.admin.entity.Category;
import com.july.admin.entity.CategoryExample;
import com.july.admin.query.CategoryQuery;
import com.july.admin.service.CategoryService;
import com.july.admin.util.ReactAdminCollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/14 00:06
 * @description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public PageInfo<CategoryBO> query(CategoryQuery categoryQuery) {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        PageHelper.startPage(categoryQuery.getPage(),categoryQuery.getSize());
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        List<CategoryBO> list = ReactAdminCollectionUtils.extractList(categories, x -> categoryConverter.convert(x));
        return new PageInfo<CategoryBO>(list);
    }

    @Override
    public Integer remove(Long id) {
        return null;
    }

    @Override
    public CategoryBO update(CategoryBO bo) {
        return null;
    }

    @Override
    public CategoryBO add(CategoryBO bo) {
        return null;
    }


}
