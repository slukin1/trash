package com.huobi.view.chart.utils;

import com.huobi.view.chart.utils.ObjectPool;
import java.util.List;

public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;

    /* renamed from: x  reason: collision with root package name */
    public double f19014x;

    /* renamed from: y  reason: collision with root package name */
    public double f19015y;

    static {
        ObjectPool<MPPointD> create = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    private MPPointD(double d11, double d12) {
        this.f19014x = d11;
        this.f19015y = d12;
    }

    public static MPPointD getInstance(double d11, double d12) {
        MPPointD mPPointD = pool.get();
        mPPointD.f19014x = d11;
        mPPointD.f19015y = d12;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        pool.recycle(mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        pool.recycle(list);
    }

    public ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f19014x + ", y: " + this.f19015y;
    }
}
