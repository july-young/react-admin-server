package com.july.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.july.admin.beans.SnowflakeIdWorker;
import com.july.admin.bo.CategoryBO;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.CategoryConverter;
import com.july.admin.dao.CategoryMapper;
import com.july.admin.dto.CategoryTreeDTO;
import com.july.admin.entity.Category;
import com.july.admin.entity.CategoryExample;
import com.july.admin.query.CategoryQuery;
import com.july.admin.service.CategoryService;
import com.july.admin.util.RACollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public PageInfo<CategoryBO> query(CategoryQuery categoryQuery) {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria()
                .andParentIdEqualTo(categoryQuery.getParentId())
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID);

        PageHelper.startPage(categoryQuery.getPage(), categoryQuery.getSize());
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        List<CategoryBO> list = RACollectionUtils.extractList(categories, x -> categoryConverter.convert(x));
        return new PageInfo<CategoryBO>(list);
    }

    @Override
    public Integer remove(Long id) {
        return null;
    }

    @Override
    public CategoryBO update(CategoryBO bo) {
        Category category = categoryConverter.revert(bo);


        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(bo.getId());

        categoryMapper.updateByExampleSelective(category, categoryExample);

        Category res = categoryMapper.selectByPrimaryKey(bo.getId());
        return categoryConverter.convert(res);
    }

    @Override
    public CategoryBO add(CategoryBO bo) {

        long id = snowflakeIdWorker.nextId();

        Category category = categoryConverter.revert(bo);
        category.setId(id);

        categoryMapper.insertSelective(category);

        Category res = categoryMapper.selectByPrimaryKey(id);
        return categoryConverter.convert(res);
    }

    @Override
    public List<CategoryBO> findParents(Long id) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria()
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        List<CategoryBO> list = RACollectionUtils.extractList(categories, x -> categoryConverter.convert(x));
        Stack<CategoryBO> stack = new Stack();
        findParents(list,id,stack);

        return RACollectionUtils.toList(stack);
    }

    @Override
    public List<CategoryTreeDTO> findCategoryOptions(Long id) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria()
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID);
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        List<CategoryBO> list = RACollectionUtils.extractList(categories, x -> categoryConverter.convert(x));
        return categoryConverter.convert2DTO(list);
    }

    private Stack<CategoryBO> findParents(List<CategoryBO> list, Long id,Stack<CategoryBO> stack) {

        Optional<CategoryBO> categoryBOOptional = list.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst();
        List<CategoryBO> others = list.stream().filter(x -> !Objects.equals(x.getId(), id)).collect(Collectors.toList());
        if (categoryBOOptional.isPresent()) {
            stack.add(categoryBOOptional.get());
            findParents(others, categoryBOOptional.get().getParentId(),stack);
        }
        return stack;
    }
}
