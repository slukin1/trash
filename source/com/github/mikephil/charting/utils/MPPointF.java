package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;

public class MPPointF extends ObjectPool.Poolable {

    /* renamed from: e  reason: collision with root package name */
    public static ObjectPool<MPPointF> f65544e;

    /* renamed from: f  reason: collision with root package name */
    public static final Parcelable.Creator<MPPointF> f65545f = new a();

    /* renamed from: c  reason: collision with root package name */
    public float f65546c;

    /* renamed from: d  reason: collision with root package name */
    public float f65547d;

    public static class a implements Parcelable.Creator<MPPointF> {
        /* renamed from: a */
        public MPPointF createFromParcel(Parcel parcel) {
            MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
            mPPointF.e(parcel);
            return mPPointF;
        }

        /* renamed from: b */
        public MPPointF[] newArray(int i11) {
            return new MPPointF[i11];
        }
    }

    static {
        ObjectPool<MPPointF> a11 = ObjectPool.a(32, new MPPointF(0.0f, 0.0f));
        f65544e = a11;
        a11.g(0.5f);
    }

    public MPPointF() {
    }

    public static MPPointF b() {
        return f65544e.b();
    }

    public static MPPointF c(float f11, float f12) {
        MPPointF b11 = f65544e.b();
        b11.f65546c = f11;
        b11.f65547d = f12;
        return b11;
    }

    public static MPPointF d(MPPointF mPPointF) {
        MPPointF b11 = f65544e.b();
        b11.f65546c = mPPointF.f65546c;
        b11.f65547d = mPPointF.f65547d;
        return b11;
    }

    public static void f(MPPointF mPPointF) {
        f65544e.c(mPPointF);
    }

    public ObjectPool.Poolable a() {
        return new MPPointF(0.0f, 0.0f);
    }

    public void e(Parcel parcel) {
        this.f65546c = parcel.readFloat();
        this.f65547d = parcel.readFloat();
    }

    public MPPointF(float f11, float f12) {
        this.f65546c = f11;
        this.f65547d = f12;
    }
}
