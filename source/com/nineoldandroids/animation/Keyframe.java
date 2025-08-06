package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public float f28247b;

    /* renamed from: c  reason: collision with root package name */
    public Class f28248c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f28249d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28250e = false;

    public static Keyframe g(float f11) {
        return new a(f11);
    }

    public static Keyframe h(float f11, int i11) {
        return new a(f11, i11);
    }

    /* renamed from: b */
    public abstract Keyframe clone();

    public float c() {
        return this.f28247b;
    }

    public Interpolator d() {
        return this.f28249d;
    }

    public abstract Object e();

    public boolean f() {
        return this.f28250e;
    }

    public void i(Interpolator interpolator) {
        this.f28249d = interpolator;
    }

    public abstract void j(Object obj);

    public static class a extends Keyframe {

        /* renamed from: f  reason: collision with root package name */
        public int f28251f;

        public a(float f11, int i11) {
            this.f28247b = f11;
            this.f28251f = i11;
            this.f28248c = Integer.TYPE;
            this.f28250e = true;
        }

        public Object e() {
            return Integer.valueOf(this.f28251f);
        }

        public void j(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.f28251f = ((Integer) obj).intValue();
                this.f28250e = true;
            }
        }

        /* renamed from: k */
        public a clone() {
            a aVar = new a(c(), this.f28251f);
            aVar.i(d());
            return aVar;
        }

        public int l() {
            return this.f28251f;
        }

        public a(float f11) {
            this.f28247b = f11;
            this.f28248c = Integer.TYPE;
        }
    }
}
