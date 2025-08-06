package com.huobi.view.chart.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.huobi.view.chart.utils.ObjectPool;
import java.util.List;

public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> CREATOR = new Parcelable.Creator<MPPointF>() {
        public MPPointF createFromParcel(Parcel parcel) {
            MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
            mPPointF.my_readFromParcel(parcel);
            return mPPointF;
        }

        public MPPointF[] newArray(int i11) {
            return new MPPointF[i11];
        }
    };
    private static ObjectPool<MPPointF> pool;

    /* renamed from: x  reason: collision with root package name */
    public float f19016x;

    /* renamed from: y  reason: collision with root package name */
    public float f19017y;

    static {
        ObjectPool<MPPointF> create = ObjectPool.create(32, new MPPointF(0.0f, 0.0f));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public MPPointF() {
    }

    public static MPPointF getInstance(float f11, float f12) {
        MPPointF mPPointF = pool.get();
        mPPointF.f19016x = f11;
        mPPointF.f19017y = f12;
        return mPPointF;
    }

    public static void recycleInstance(MPPointF mPPointF) {
        pool.recycle(mPPointF);
    }

    public static void recycleInstances(List<MPPointF> list) {
        pool.recycle(list);
    }

    public float getX() {
        return this.f19016x;
    }

    public float getY() {
        return this.f19017y;
    }

    public ObjectPool.Poolable instantiate() {
        return new MPPointF(0.0f, 0.0f);
    }

    public void my_readFromParcel(Parcel parcel) {
        this.f19016x = parcel.readFloat();
        this.f19017y = parcel.readFloat();
    }

    public MPPointF(float f11, float f12) {
        this.f19016x = f11;
        this.f19017y = f12;
    }

    public static MPPointF getInstance() {
        return pool.get();
    }

    public static MPPointF getInstance(MPPointF mPPointF) {
        MPPointF mPPointF2 = pool.get();
        mPPointF2.f19016x = mPPointF.f19016x;
        mPPointF2.f19017y = mPPointF.f19017y;
        return mPPointF2;
    }
}
