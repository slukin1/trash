package com.squareup.wire.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a {
    public static <T> List<T> a(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        } else if (list == Collections.emptyList() || (list instanceof ImmutableList)) {
            return new MutableOnWriteList(list);
        } else {
            return new ArrayList(list);
        }
    }

    public static <K, V> Map<K, V> b(String str, Map<K, V> map) {
        if (map != null) {
            return new LinkedHashMap(map);
        }
        throw new NullPointerException(str + " == null");
    }

    public static int c(Object obj, Object obj2, Object obj3) {
        int i11 = 1;
        int i12 = (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0);
        if (obj3 == null) {
            i11 = 0;
        }
        return i12 + i11;
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> List<T> e(String str, List<T> list) {
        if (list != null) {
            if (list instanceof MutableOnWriteList) {
                list = ((MutableOnWriteList) list).mutableList;
            }
            if (list == Collections.emptyList() || (list instanceof ImmutableList)) {
                return list;
            }
            ImmutableList immutableList = new ImmutableList(list);
            if (!immutableList.contains((Object) null)) {
                return immutableList;
            }
            throw new IllegalArgumentException(str + ".contains(null)");
        }
        throw new NullPointerException(str + " == null");
    }

    public static <K, V> Map<K, V> f(String str, Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException(str + " == null");
        } else if (map.isEmpty()) {
            return Collections.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            if (linkedHashMap.containsKey((Object) null)) {
                throw new IllegalArgumentException(str + ".containsKey(null)");
            } else if (!linkedHashMap.containsValue((Object) null)) {
                return Collections.unmodifiableMap(linkedHashMap);
            } else {
                throw new IllegalArgumentException(str + ".containsValue(null)");
            }
        }
    }

    public static <T> List<T> g() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> h() {
        return new LinkedHashMap();
    }
}
