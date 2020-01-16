package com.july.admin.common;

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
}
