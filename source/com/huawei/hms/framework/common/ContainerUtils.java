package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        boolean z11;
        if (map == map2) {
            return true;
        }
        if (!(map == null || map2 == null || map.size() != map2.size())) {
            Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z11 = false;
                    break;
                }
                Map.Entry next = it2.next();
                if (map2.get(next.getKey()) != next.getValue()) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (Map.Entry next : map.entrySet()) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(FIELD_DELIMITER);
            }
            sb2.append(next.getKey().toString());
            sb2.append(KEY_VALUE_DELIMITER);
            sb2.append(next.getValue().toString());
            i11 = i12;
        }
        return sb2.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (K next : set) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(FIELD_DELIMITER);
            }
            sb2.append(next.toString());
            i11 = i12;
        }
        return sb2.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (K next : list) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(FIELD_DELIMITER);
            }
            sb2.append(next.toString());
            i11 = i12;
        }
        return sb2.toString();
    }
}
