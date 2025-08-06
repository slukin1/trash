package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;

public final class ConcurrentV8 {

    /* renamed from: v8  reason: collision with root package name */
    private V8 f64942v8 = null;

    public ConcurrentV8() {
        V8 createV8Runtime = V8.createV8Runtime();
        this.f64942v8 = createV8Runtime;
        createV8Runtime.getLocker().release();
    }

    public V8 getV8() {
        return this.f64942v8;
    }

    public void release() {
        V8 v82 = this.f64942v8;
        if (v82 != null && !v82.isReleased()) {
            run(new V8Runnable() {
                public void run(V8 v82) {
                    if (v82 != null && !v82.isReleased()) {
                        v82.close();
                    }
                }
            });
        }
    }

    public synchronized void run(V8Runnable v8Runnable) {
        try {
            this.f64942v8.getLocker().acquire();
            v8Runnable.run(this.f64942v8);
            V8 v82 = this.f64942v8;
            if (!(v82 == null || v82.getLocker() == null || !this.f64942v8.getLocker().hasLock())) {
                this.f64942v8.getLocker().release();
            }
        } catch (Throwable th2) {
            V8 v83 = this.f64942v8;
            if (!(v83 == null || v83.getLocker() == null || !this.f64942v8.getLocker().hasLock())) {
                this.f64942v8.getLocker().release();
            }
            throw th2;
        }
    }
}
