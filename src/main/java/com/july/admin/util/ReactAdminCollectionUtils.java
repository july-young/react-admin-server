package com.july.admin.util;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/1/7 08:43
 * @description:
 */
public class ReactAdminCollectionUtils extends CollectionUtils {

    public static <T, R> List<R> extractList(Collection<T> collection, Function<T, R> function) {
        return collection.stream().filter(Objects::nonNull).map(function).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<T, K> keyFun, Function<T, V> valueFun) {
        return collection.stream().filter(Objects::nonNull)
                .collect(Collectors.toMap(keyFun, valueFun));
    }

    public static <T, K> Set<K> toSet(Collection<T> collection, Function<T, K> keyFun) {
        return collection.stream().filter(Objects::nonNull).map(keyFun)
                .collect(Collectors.toSet());
    }

    public static <T, K> List<K> toSetList(Collection<T> collection, Function<T, K> keyFun) {
        return collection.stream().filter(Objects::nonNull).map(keyFun).distinct()
                .collect(Collectors.toList());
    }

    /**
     * 逆序弹出
     *
     * @param stack
     * @param <E>
     * @return
     */
    public static <E> List<E> toList(Stack<E> stack) {
        List<E> list = new LinkedList<>();
         toList(list, stack);
         return list;
    }

    private static <E> void toList(List<E> list, Stack<E> stack) {
        for (int i = 0; i < stack.size(); ) {
            list.add(stack.pop());
        }
    }
}
