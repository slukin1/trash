package com.alibaba.android.arouter.utils;

import java.util.Map;

public class MapUtils {
    public static boolean a(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean b(Map<?, ?> map) {
        return !a(map);
    }
}
