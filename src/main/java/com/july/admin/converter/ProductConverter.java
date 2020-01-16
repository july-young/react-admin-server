package com.july.admin.converter;

import com.july.admin.bo.ProductBO;
import com.july.admin.common.Converter;
import com.july.admin.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/1/16 23:54
 * @description:
 */
@Component
public class ProductConverter implements Converter<Product,ProductBO> {
    @Override
    public ProductBO convert(Product d) {
        if(d ==null){
            return null;
        }
        ProductBO b = new ProductBO();
        BeanUtils.copyProperties(d,b);
        return b;
    }

    @Override
    public Product revert(ProductBO b) {
        if(b==null){
            return null;
        }
        Product d = new Product();
        BeanUtils.copyProperties(b,d);
        return d;
    }
}
