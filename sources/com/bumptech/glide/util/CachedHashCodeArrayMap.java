package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: j  reason: collision with root package name */
    public int f64262j;

    public void clear() {
        this.f64262j = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f64262j == 0) {
            this.f64262j = super.hashCode();
        }
        return this.f64262j;
    }

    public void m(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f64262j = 0;
        super.m(simpleArrayMap);
    }

    public V n(int i11) {
        this.f64262j = 0;
        return super.n(i11);
    }

    public V o(int i11, V v11) {
        this.f64262j = 0;
        return super.o(i11, v11);
    }

    public V put(K k11, V v11) {
        this.f64262j = 0;
        return super.put(k11, v11);
    }
}
