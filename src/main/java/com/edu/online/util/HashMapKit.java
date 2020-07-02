package com.edu.online.util;

import java.util.HashMap;
import java.util.Map;

import lombok.experimental.UtilityClass;

/**
 * hashMap工具类
 * 定义了一些常用大小
 * 解决需要new HashMap要求传大小，又不能有魔法数字的问题.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@UtilityClass
public class HashMapKit {
    private static final int QUARTER_SIZE = 4;
    private static final int HALF_SIZE = 8;
    private static final int DEFAULT_SIZE = 16;

    /**
     * 扩容因子1，在已知大小的情况下防止0.75的扩容.
     */
    private static final float LOAD_FACTOR = 1F;

    /**
     * 创建一个大小为4，扩容因子为1的HashMap.
     *
     * @param <K> key
     * @param <V> value
     * @return Map
     */
    public static <K, V> Map<K, V> newFixQuarterSize() {
        return new HashMap<>(QUARTER_SIZE, LOAD_FACTOR);
    }

    /**
     * 创建一个大小为8，扩容因子为1的HashMap.
     *
     * @param <K> key
     * @param <V> value
     * @return Map
     */
    public static <K, V> Map<K, V> newFixHalfSize() {
        return new HashMap<>(HALF_SIZE, LOAD_FACTOR);
    }

    /**
     * 创建一个大小为16，扩容因子为1的HashMap.
     *
     * @param <K> key
     * @param <V> value
     * @return Map
     */
    public static <K, V> Map<K, V> newFixDefaultSize() {
        return new HashMap<>(DEFAULT_SIZE, LOAD_FACTOR);
    }

    /**
     * 创建一个大小为16，扩容因子为0.75的HashMap.
     *
     * @param <K> key
     * @param <V> value
     * @return Map
     */
    public static <K, V> Map<K, V> newDefaultSize() {
        return new HashMap<>(DEFAULT_SIZE);
    }

    /**
     * 创建一个指定大小，扩容因子为0.75的HashMap.
     *
     * @param size 大小
     * @param <K>  key
     * @param <V>  value
     * @return Map
     */
    public static <K, V> Map<K, V> newSize(int size) {
        return new HashMap<>(size);
    }

    /**
     * 创建一个指定大小，扩容因子为1的HashMap.
     *
     * @param size 大小
     * @param <K>  key
     * @param <V>  value
     * @return Map
     */
    public static <K, V> Map<K, V> newFixSize(int size) {
        return new HashMap<>(size, LOAD_FACTOR);
    }

}
