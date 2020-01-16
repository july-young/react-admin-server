package com.july.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.july.admin.bo.CategoryBO;
import com.july.admin.bo.ProductBO;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.ProductConverter;
import com.july.admin.dao.ProductMapper;
import com.july.admin.entity.Product;
import com.july.admin.entity.ProductExample;
import com.july.admin.query.ProductQuery;
import com.july.admin.service.ProductService;
import com.july.admin.util.ReactAdminCollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/16 23:58
 * @description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo<ProductBO> query(ProductQuery productQuery) {


        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria()
                .andStateEqualTo(ReactAdminConstant.MetaState.VALID);

        if(productQuery.getName()!=null){
            criteria.andNameLike(productQuery.getName());
        }
        if(productQuery.getDetail()!=null){
            criteria.andDetailLike(productQuery.getDetail());
        }

        PageHelper.startPage(productQuery.getPage(),productQuery.getSize());
        List<Product> products = productMapper.selectByExample(example);

        List<ProductBO> productBOS = ReactAdminCollectionUtils.extractList(products, x -> productConverter.convert(x));


        return new PageInfo<ProductBO>(productBOS);
    }

    @Override
    public Integer remove(Long id) {
        return null;
    }

    @Override
    public ProductBO update(ProductBO bo) {
        return null;
    }

    @Override
    public ProductBO add(ProductBO bo) {
        return null;
    }
}
