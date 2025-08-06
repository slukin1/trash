package com.alibaba.android.arouter.base;

import java.util.TreeMap;

public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {
    private String tipText;

    public UniqueKeyTreeMap(String str) {
        this.tipText = str;
    }

    public V put(K k11, V v11) {
        if (!containsKey(k11)) {
            return super.put(k11, v11);
        }
        throw new RuntimeException(String.format(this.tipText, new Object[]{k11}));
    }
}
