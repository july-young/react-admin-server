package com.july.admin.common;

import com.july.admin.util.RACollectionUtils;

import java.util.List;

/**
 * @author: july
 * @date: 2020/1/6 23:44
 * @description:
 */
public interface Converter<DO,BO> {
    /**
     * 转为bo对象
     * @param d
     * @return
     */
    BO convert(DO d);

    /**
     * 转为do对象
     * @param b
     * @return
     */
    DO revert(BO b);

    /**
     * 批量转换为BO
     * @param list
     * @return
     */
    default List<BO> convert(List<DO> list){
        return RACollectionUtils.extractList(list,x->convert(x));
    }
}
