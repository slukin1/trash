package com.bumptech.glide.util;

import f4.i;

public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f64263a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f64264b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f64265c;

    public MultiClassKey() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f64263a = cls;
        this.f64264b = cls2;
        this.f64265c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f64263a.equals(multiClassKey.f64263a) && this.f64264b.equals(multiClassKey.f64264b) && i.d(this.f64265c, multiClassKey.f64265c);
    }

    public int hashCode() {
        int hashCode = ((this.f64263a.hashCode() * 31) + this.f64264b.hashCode()) * 31;
        Class<?> cls = this.f64265c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f64263a + ", second=" + this.f64264b + '}';
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
