package com.july.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.july.admin.beans.SnowflakeIdWorker;
import com.july.admin.bo.ProductBO;
import com.july.admin.constant.ReactAdminConstant;
import com.july.admin.converter.ProductConverter;
import com.july.admin.dao.ProductMapper;
import com.july.admin.entity.Product;
import com.july.admin.entity.ProductExample;
import com.july.admin.enums.ProductStatusEnum;
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
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
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
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductBO update(ProductBO bo) {
        productMapper.updateByPrimaryKeySelective(productConverter.revert(bo));
        Product product = productMapper.selectByPrimaryKey(bo.getId());
        return productConverter.convert(product);
    }

    @Override
    public ProductBO add(ProductBO bo) {
        Product product = productConverter.revert(bo);
        long id = snowflakeIdWorker.nextId();
        product.setId(id);
        product.setState(ReactAdminConstant.MetaState.VALID);
        productMapper.insertSelective(product);
        return productConverter.convert(productMapper.selectByPrimaryKey(id));
    }

    @Override
    public int updateStatus(Long id, ProductStatusEnum productStatusEnum) {
        Product product = new Product();
        product.setId(id);
        product.setStatus(productStatusEnum.getCode().byteValue());
        product.setState(ReactAdminConstant.MetaState.VALID);
        return productMapper.updateByPrimaryKeySelective(product);
    }
}
