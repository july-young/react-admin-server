package com.july.admin.common;

import javafx.util.Pair;

import java.util.Objects;

/**
 * @author: july
 * @date: 2020/1/11 00:30
 * @description:
 */
public class RAPair<K,V> extends Pair<K,V> {
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public RAPair(K key, V value) {
        super(key, value);
    }

    @Override
    public int hashCode() {
        return (""+super.getKey()+super.getValue()).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o==null || ! (o instanceof  RAPair)){
            return false;
        }
        RAPair t = (RAPair) o;
        if(Objects.equals(t.getKey(),this.getKey()) && Objects.equals(t.getValue(),this.getValue())){
            return true;
        }
        return false;
    }
}
