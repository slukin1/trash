package com.huobi.view.chart.utils;

import com.huobi.view.chart.utils.ObjectPool;
import java.util.List;

public final class FSize extends ObjectPool.Poolable {
    private static ObjectPool<FSize> pool;
    public float height;
    public float width;

    static {
        ObjectPool<FSize> create = ObjectPool.create(256, new FSize(0.0f, 0.0f));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public FSize() {
    }

    public static FSize getInstance(float f11, float f12) {
        FSize fSize = pool.get();
        fSize.width = f11;
        fSize.height = f12;
        return fSize;
    }

    public static void recycleInstance(FSize fSize) {
        pool.recycle(fSize);
    }

    public static void recycleInstances(List<FSize> list) {
        pool.recycle(list);
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
        if (this.width == fSize.width && this.height == fSize.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }

    public ObjectPool.Poolable instantiate() {
        return new FSize(0.0f, 0.0f);
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public FSize(float f11, float f12) {
        this.width = f11;
        this.height = f12;
    }
}
