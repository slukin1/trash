package com.huobi.view.chart.utils;

import com.huobi.view.chart.utils.ObjectPool.Poolable;
import java.util.List;

public class ObjectPool<T extends Poolable> {
    private static int ids;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        public int currentOwnerId = NO_OWNER;

        public abstract Poolable instantiate();
    }

    private ObjectPool(int i11, T t11) {
        if (i11 > 0) {
            this.desiredCapacity = i11;
            this.objects = new Object[i11];
            this.objectsPointer = 0;
            this.modelObject = t11;
            this.replenishPercentage = 1.0f;
            refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized ObjectPool create(int i11, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i11, poolable);
            int i12 = ids;
            objectPool.poolId = i12;
            ids = i12 + 1;
        }
        return objectPool;
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    private void resizePool() {
        int i11 = this.desiredCapacity;
        int i12 = i11 * 2;
        this.desiredCapacity = i12;
        Object[] objArr = new Object[i12];
        for (int i13 = 0; i13 < i11; i13++) {
            objArr[i13] = this.objects[i13];
        }
        this.objects = objArr;
    }

    public synchronized T get() {
        T t11;
        if (this.objectsPointer == -1 && this.replenishPercentage > 0.0f) {
            refillPool();
        }
        T[] tArr = this.objects;
        int i11 = this.objectsPointer;
        t11 = (Poolable) tArr[i11];
        t11.currentOwnerId = Poolable.NO_OWNER;
        this.objectsPointer = i11 - 1;
        return t11;
    }

    public int getPoolCapacity() {
        return this.objects.length;
    }

    public int getPoolCount() {
        return this.objectsPointer + 1;
    }

    public int getPoolId() {
        return this.poolId;
    }

    public float getReplenishPercentage() {
        return this.replenishPercentage;
    }

    public synchronized void recycle(T t11) {
        int i11 = t11.currentOwnerId;
        if (i11 == Poolable.NO_OWNER) {
            int i12 = this.objectsPointer + 1;
            this.objectsPointer = i12;
            if (i12 >= this.objects.length) {
                resizePool();
            }
            t11.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer] = t11;
        } else if (i11 == this.poolId) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t11.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }

    public void setReplenishPercentage(float f11) {
        if (f11 > 1.0f) {
            f11 = 1.0f;
        } else if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.replenishPercentage = f11;
    }

    private void refillPool(float f11) {
        int i11 = this.desiredCapacity;
        int i12 = (int) (((float) i11) * f11);
        if (i12 < 1) {
            i11 = 1;
        } else if (i12 <= i11) {
            i11 = i12;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            this.objects[i13] = this.modelObject.instantiate();
        }
        this.objectsPointer = i11 - 1;
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.objectsPointer + 1 > this.desiredCapacity) {
            resizePool();
        }
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            Poolable poolable = (Poolable) list.get(i11);
            int i12 = poolable.currentOwnerId;
            if (i12 == Poolable.NO_OWNER) {
                poolable.currentOwnerId = this.poolId;
                this.objects[this.objectsPointer + 1 + i11] = poolable;
                i11++;
            } else if (i12 == this.poolId) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + poolable.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        }
        this.objectsPointer += size;
    }
}
