package com.tencent.thumbplayer.tcmedia.utils;

import java.util.HashMap;
import java.util.Map;

public class g<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private Map<K, V> f49701a = new HashMap();

    public g<K, V> a(K k11, V v11) {
        this.f49701a.put(k11, v11);
        return this;
    }

    public Map<K, V> a() {
        return this.f49701a;
    }
}
