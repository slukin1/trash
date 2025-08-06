package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

public final class FSize extends ObjectPool.Poolable {

    /* renamed from: e  reason: collision with root package name */
    public static ObjectPool<FSize> f65541e;

    /* renamed from: c  reason: collision with root package name */
    public float f65542c;

    /* renamed from: d  reason: collision with root package name */
    public float f65543d;

    static {
        ObjectPool<FSize> a11 = ObjectPool.a(256, new FSize(0.0f, 0.0f));
        f65541e = a11;
        a11.g(0.5f);
    }

    public FSize() {
    }

    public static FSize b(float f11, float f12) {
        FSize b11 = f65541e.b();
        b11.f65542c = f11;
        b11.f65543d = f12;
        return b11;
    }

    public static void c(FSize fSize) {
        f65541e.c(fSize);
    }

    public ObjectPool.Poolable a() {
        return new FSize(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSize)) {
            return false;
        }
        FSize fSize = (FSize) obj;
        if (this.f65542c == fSize.f65542c && this.f65543d == fSize.f65543d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f65542c) ^ Float.floatToIntBits(this.f65543d);
    }

    public String toString() {
        return this.f65542c + "x" + this.f65543d;
    }

    public FSize(float f11, float f12) {
        this.f65542c = f11;
        this.f65543d = f12;
    }
}
