package com.july.admin.converter;

import com.july.admin.bo.CategoryBO;
import com.july.admin.common.Converter;
import com.july.admin.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/1/14 00:03
 * @description:
 */
@Component
public class CategoryConverter implements Converter<Category,CategoryBO> {
    @Override
    public CategoryBO convert(Category d) {
        if(d==null){
            return null;
        }
        CategoryBO b = new CategoryBO();
        BeanUtils.copyProperties(d,b);
        return b;
    }

    @Override
    public Category revert(CategoryBO b) {
        if(b==null){
            return null;
        }
        Category d = new Category();
        BeanUtils.copyProperties(b,d);
        return d;
    }
}
