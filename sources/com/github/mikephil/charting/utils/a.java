package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

public class a extends ObjectPool.Poolable {

    /* renamed from: e  reason: collision with root package name */
    public static ObjectPool<a> f65587e;

    /* renamed from: c  reason: collision with root package name */
    public double f65588c;

    /* renamed from: d  reason: collision with root package name */
    public double f65589d;

    static {
        ObjectPool<a> a11 = ObjectPool.a(64, new a(0.0d, 0.0d));
        f65587e = a11;
        a11.g(0.5f);
    }

    public a(double d11, double d12) {
        this.f65588c = d11;
        this.f65589d = d12;
    }

    public static a b(double d11, double d12) {
        a b11 = f65587e.b();
        b11.f65588c = d11;
        b11.f65589d = d12;
        return b11;
    }

    public static void c(a aVar) {
        f65587e.c(aVar);
    }

    public ObjectPool.Poolable a() {
        return new a(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f65588c + ", y: " + this.f65589d;
    }
}
