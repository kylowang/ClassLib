/**
 * net.kylo.util.SetUtil.java
 * <p>
 * ver     date      		author
 * ──────────────────────────────────
 * 1.0   2017/4/12 22:50  wangxiaoming
 * <p>
 * Copyright (c) 2017, TNT All Rights Reserved.
 */
package net.kylo.util;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>ClassName: SetUtil</p>
 * <p>Description: 提供数学中的集合操作</p>
 * @author wangxiaoming
 * @Date 2017-04-12 22:50
 */
public class SetUtil {
    /**
     * <p>Description: 并集</p>
     * 
     * @Author wangxiaoming
     * @Date 2017/4/12 22:54
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    /**
     * <p>Description: 交集</p>
     * 
     * @Author wangxiaoming
     * @Date 2017/4/12 22:55
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * <p>Description: 排除</p>
     * 
     * @Author wangxiaoming
     * @Date 2017/4/12 22:55
     */
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.removeAll(b);
        return result;
    }

    /**
     * <p>Description: 去重</p>
     * 
     * @Author wangxiaoming
     * @Date 2017/4/12 22:55
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    public static void main(String[] args) {
        Set a = new HashSet<Integer>();
        Set b = new HashSet<Integer>();

        a.add(1);
        a.add(2);

        b.add(2);
        b.add(3);

        System.out.println(union(a, b));
        System.out.println(intersection(a, b));
        System.out.println(difference(a, b));
        System.out.println(complement(a, b));
    }
}
