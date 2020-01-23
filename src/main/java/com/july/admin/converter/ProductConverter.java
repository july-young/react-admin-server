package com.july.admin.converter;

import com.alibaba.fastjson.JSON;
import com.july.admin.bo.ProductBO;
import com.july.admin.common.Converter;
import com.july.admin.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
        List<String> list = JSON.parseArray(d.getImgs(), String.class);
        if(CollectionUtils.isEmpty(list)){
           b.setImgs(new ArrayList<>());
        }else{
            b.setImgs(list);
        }

        return b;
    }

    @Override
    public Product revert(ProductBO b) {
        if(b==null){
            return null;
        }
        Product d = new Product();
        BeanUtils.copyProperties(b,d);

        if(CollectionUtils.isEmpty(b.getImgs())){
            d.setImgs("[]");
        }else{
            d.setImgs(JSON.toJSONString(b.getImgs()));
        }

        return d;
    }
}
