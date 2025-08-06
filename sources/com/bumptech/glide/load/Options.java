package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import n3.b;
import n3.d;

public final class Options implements b {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<d<?>, Object> f63657b = new CachedHashCodeArrayMap();

    public static <T> void d(d<T> dVar, Object obj, MessageDigest messageDigest) {
        dVar.g(obj, messageDigest);
    }

    public <T> T a(d<T> dVar) {
        return this.f63657b.containsKey(dVar) ? this.f63657b.get(dVar) : dVar.c();
    }

    public void b(Options options) {
        this.f63657b.m(options.f63657b);
    }

    public <T> Options c(d<T> dVar, T t11) {
        this.f63657b.put(dVar, t11);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f63657b.equals(((Options) obj).f63657b);
        }
        return false;
    }

    public int hashCode() {
        return this.f63657b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f63657b + '}';
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i11 = 0; i11 < this.f63657b.size(); i11++) {
            d(this.f63657b.l(i11), this.f63657b.p(i11), messageDigest);
        }
    }
}
