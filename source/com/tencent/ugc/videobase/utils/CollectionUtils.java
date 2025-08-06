package com.tencent.ugc.videobase.utils;

import java.util.Collection;

public class CollectionUtils {
    public static boolean containsAny(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() < collection2.size()) {
            for (Object contains : collection) {
                if (collection2.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
        for (Object contains2 : collection2) {
            if (collection.contains(contains2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
