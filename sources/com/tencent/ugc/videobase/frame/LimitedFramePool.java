package com.tencent.ugc.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.frame.RefCounted;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public abstract class LimitedFramePool<T extends RefCounted> {
    private static final String TAG = "LimitedFramePool";
    /* access modifiers changed from: private */
    public final Deque<T> mDeque = new LinkedList();
    /* access modifiers changed from: private */
    public volatile boolean mIsDestroyed = false;
    private final IRecycler<T> mRecycler = new IRecycler<T>() {
        public final void recycle(T t11) {
            if (t11 != null) {
                LimitedFramePool.this.mSemaphore.release();
                synchronized (LimitedFramePool.this) {
                    if (LimitedFramePool.this.mIsDestroyed) {
                        LimitedFramePool.this.destroyInstance(t11);
                    } else {
                        LimitedFramePool.this.mDeque.addFirst(t11);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public final Semaphore mSemaphore;

    public LimitedFramePool(int i11) {
        this.mSemaphore = new Semaphore(i11);
    }

    public abstract T createInstance(IRecycler<T> iRecycler);

    public void destroy() {
        this.mIsDestroyed = true;
        evictAll();
    }

    public abstract void destroyInstance(T t11);

    public void evictAll() {
        ArrayList<RefCounted> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>(this.mDeque);
            this.mDeque.clear();
        }
        for (RefCounted destroyInstance : arrayList) {
            destroyInstance(destroyInstance);
        }
    }

    public T obtain() throws InterruptedException {
        T t11;
        this.mSemaphore.acquire();
        synchronized (this) {
            if (!this.mDeque.isEmpty()) {
                t11 = (RefCounted) this.mDeque.removeFirst();
            } else {
                t11 = createInstance(this.mRecycler);
            }
        }
        if (t11.retain() != 1) {
            LiteavLog.e(TAG, "invalid reference count for %s", t11);
        }
        return t11;
    }
}
