/**
 * net.kylo.util.NewCollection.java
 * <p>
 * ver     date      		author
 * ──────────────────────────────────
 * 1.0   2017/4/11 22:55  wangxiaoming
 * <p>
 * Copyright (c) 2017, TNT All Rights Reserved.
 */
package net.kylo.util;

import java.util.*;

/**
 * <p>ClassName: NewCollection</p>
 * <p>Description: 根据类型参数推断得到得到常用的集合类</p>
 * <p>Company: 上品科技</p>
 * @author wangxiaoming
 * @Date 2017-04-11 22:55
 */
public class NewCollection {

    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static void main(String[] args) {
        Map<String, String> map = map();
        map.put("key", "value");
        System.out.println(map.get("key"));
    }
}
