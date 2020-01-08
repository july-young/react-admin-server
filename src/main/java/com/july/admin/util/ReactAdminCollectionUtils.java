package com.july.admin.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/7 08:43
 * @description:
 */
public class ReactAdminCollectionUtils extends CollectionUtils {

    public static  <T,R> List<R> extractList(Collection<T> collection, Function<T,R> function){
        return collection.stream().filter(Objects::nonNull).map(function).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static  <T,K,V> Map<K,V> toMap(Collection<T> collection, Function<T,K> keyFun, Function<T,V> valueFun){
        return collection.stream().filter(Objects::nonNull)
                .collect(Collectors.toMap(keyFun,valueFun));
    }


}
