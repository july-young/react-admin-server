package com.july.admin.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: july
 * @date: 2020/1/19 22:28
 * @description: 获取枚举实例
 */
public class EnumUtil {
    public static <E extends Enum> E getEnum(Class<E> clazz, Integer code) {
        // 得到枚举类对象
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取所有枚举实例
        Enum[] enumConstants = clazz.getEnumConstants();
        //根据方法名获取方法
        Method getCode = null;
        try {
            getCode = clazz.getMethod("getCode");
            for (Enum enum1 : enumConstants) {
                if (getCode.invoke(enum1).equals(code)) {
                    return (E) enum1;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
