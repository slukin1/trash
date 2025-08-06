package com.tencent.tpns.baseapi.base.util;

import java.util.HashMap;

public class MemoryCacheManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HashMap<Object, Object> f49823a = new HashMap<>(10);

    public static boolean containsKey(Object obj) {
        return f49823a.containsKey(obj);
    }

    public static synchronized Object get(Object obj) {
        Object obj2;
        synchronized (MemoryCacheManager.class) {
            obj2 = f49823a.get(obj);
        }
        return obj2;
    }

    public static synchronized void put(Object obj, Object obj2) {
        synchronized (MemoryCacheManager.class) {
            f49823a.put(obj, obj2);
        }
    }

    public static synchronized Object remove(Object obj) {
        Object remove;
        synchronized (MemoryCacheManager.class) {
            remove = f49823a.remove(obj);
        }
        return remove;
    }
}
