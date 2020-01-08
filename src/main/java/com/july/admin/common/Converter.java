package com.july.admin.common;

/**
 * @author: july
 * @date: 2020/1/6 23:44
 * @description:
 */
public interface Converter<DO,BO> {
    BO convert(DO d);
    DO revert(BO b);
}
