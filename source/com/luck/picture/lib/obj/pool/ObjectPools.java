package com.luck.picture.lib.obj.pool;

import java.util.LinkedList;

public final class ObjectPools {

    public interface Pool<T> {
        T acquire();

        void destroy();

        boolean release(T t11);
    }

    public static class SimpleObjectPool<T> implements Pool<T> {
        private final LinkedList<T> mPool = new LinkedList<>();

        private boolean isInPool(T t11) {
            return this.mPool.contains(t11);
        }

        public T acquire() {
            return this.mPool.poll();
        }

        public void destroy() {
            this.mPool.clear();
        }

        public boolean release(T t11) {
            if (isInPool(t11)) {
                return false;
            }
            return this.mPool.add(t11);
        }
    }

    public static class SynchronizedPool<T> extends SimpleObjectPool<T> {
        private final Object mLock = new Object();

        public T acquire() {
            T acquire;
            synchronized (this.mLock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public void destroy() {
            synchronized (this.mLock) {
                super.destroy();
            }
        }

        public boolean release(T t11) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t11);
            }
            return release;
        }
    }
}
