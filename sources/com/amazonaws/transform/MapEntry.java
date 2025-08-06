package com.amazonaws.transform;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public K f15510b;

    /* renamed from: c  reason: collision with root package name */
    public V f15511c;

    public K getKey() {
        return this.f15510b;
    }

    public V getValue() {
        return this.f15511c;
    }

    public V setValue(V v11) {
        this.f15511c = v11;
        return v11;
    }
}
