package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;

public class ObjectPool<T extends Poolable> {

    /* renamed from: g  reason: collision with root package name */
    public static int f65548g;

    /* renamed from: a  reason: collision with root package name */
    public int f65549a;

    /* renamed from: b  reason: collision with root package name */
    public int f65550b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f65551c;

    /* renamed from: d  reason: collision with root package name */
    public int f65552d;

    /* renamed from: e  reason: collision with root package name */
    public T f65553e;

    /* renamed from: f  reason: collision with root package name */
    public float f65554f;

    public static abstract class Poolable {

        /* renamed from: b  reason: collision with root package name */
        public static int f65555b = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f65556a = f65555b;

        public abstract Poolable a();
    }

    public ObjectPool(int i11, T t11) {
        if (i11 > 0) {
            this.f65550b = i11;
            this.f65551c = new Object[i11];
            this.f65552d = 0;
            this.f65553e = t11;
            this.f65554f = 1.0f;
            d();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized ObjectPool a(int i11, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i11, poolable);
            int i12 = f65548g;
            objectPool.f65549a = i12;
            f65548g = i12 + 1;
        }
        return objectPool;
    }

    public synchronized T b() {
        T t11;
        if (this.f65552d == -1 && this.f65554f > 0.0f) {
            d();
        }
        T[] tArr = this.f65551c;
        int i11 = this.f65552d;
        t11 = (Poolable) tArr[i11];
        t11.f65556a = Poolable.f65555b;
        this.f65552d = i11 - 1;
        return t11;
    }

    public synchronized void c(T t11) {
        int i11 = t11.f65556a;
        if (i11 == Poolable.f65555b) {
            int i12 = this.f65552d + 1;
            this.f65552d = i12;
            if (i12 >= this.f65551c.length) {
                f();
            }
            t11.f65556a = this.f65549a;
            this.f65551c[this.f65552d] = t11;
        } else if (i11 == this.f65549a) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t11.f65556a + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }

    public final void d() {
        e(this.f65554f);
    }

    public final void e(float f11) {
        int i11 = this.f65550b;
        int i12 = (int) (((float) i11) * f11);
        if (i12 < 1) {
            i11 = 1;
        } else if (i12 <= i11) {
            i11 = i12;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            this.f65551c[i13] = this.f65553e.a();
        }
        this.f65552d = i11 - 1;
    }

    public final void f() {
        int i11 = this.f65550b;
        int i12 = i11 * 2;
        this.f65550b = i12;
        Object[] objArr = new Object[i12];
        for (int i13 = 0; i13 < i11; i13++) {
            objArr[i13] = this.f65551c[i13];
        }
        this.f65551c = objArr;
    }

    public void g(float f11) {
        if (f11 > 1.0f) {
            f11 = 1.0f;
        } else if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.f65554f = f11;
    }
}
