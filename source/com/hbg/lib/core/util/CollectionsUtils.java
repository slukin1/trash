package com.hbg.lib.core.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CollectionsUtils {

    public interface a<T> {
        boolean a(T t11);
    }

    public static <T> int a(List<T> list, a<T> aVar) {
        int i11 = -1;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (aVar.a(list.get(i12))) {
                i11 = i12;
            }
        }
        return i11;
    }

    public static boolean b(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean c(Map map) {
        return map == null || map.size() == 0;
    }
}
