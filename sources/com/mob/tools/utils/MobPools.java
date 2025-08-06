package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;

public final class MobPools implements PublicMemberKeeper {

    public interface Pool<T> extends PublicMemberKeeper {
        T acquire();

        boolean release(T t11);
    }

    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f28120a;

        /* renamed from: b  reason: collision with root package name */
        private int f28121b;

        public SimplePool(int i11) {
            if (i11 > 0) {
                this.f28120a = new Object[i11];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean a(T t11) {
            for (int i11 = 0; i11 < this.f28121b; i11++) {
                if (this.f28120a[i11] == t11) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i11 = this.f28121b;
            if (i11 > 0) {
                int i12 = i11 - 1;
                try {
                    T[] tArr = this.f28120a;
                    T t11 = tArr[i12];
                    tArr[i12] = null;
                    this.f28121b = i11 - 1;
                    return t11;
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            return null;
        }

        public boolean release(T t11) {
            if (!a(t11)) {
                int i11 = this.f28121b;
                Object[] objArr = this.f28120a;
                if (i11 >= objArr.length) {
                    return false;
                }
                objArr[i11] = t11;
                this.f28121b = i11 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    private MobPools() {
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f28122a;

        public SynchronizedPool(int i11, Object obj) {
            super(i11);
            this.f28122a = obj;
        }

        public T acquire() {
            T acquire;
            synchronized (this.f28122a) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t11) {
            boolean release;
            synchronized (this.f28122a) {
                release = super.release(t11);
            }
            return release;
        }

        public SynchronizedPool(int i11) {
            this(i11, new Object());
        }
    }
}
