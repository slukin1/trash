package io.reactivex.rxjava3.internal.util;

import j00.k;
import java.util.HashMap;
import java.util.Map;

public enum HashMapSupplier implements k<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> k<Map<K, V>> asSupplier() {
        return INSTANCE;
    }

    public Map<Object, Object> get() {
        return new HashMap();
    }
}
