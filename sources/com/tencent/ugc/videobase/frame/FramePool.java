package com.tencent.ugc.videobase.frame;

import android.os.SystemClock;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.frame.RefCounted;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class FramePool<T extends RefCounted> {
    private static final long MAX_TIME_OUT = TimeUnit.SECONDS.toMillis(1);
    private static final String TAG = "FramePool";
    private final Map<Key, Deque<T>> mDequeMap = new HashMap();
    private final a mEvictThrottler = new a(MAX_TIME_OUT);
    private volatile boolean mIsDestroyed = false;
    private final IRecycler<T> mRecycler = a.a(this);
    private final String mStackTrace = null;

    public interface Key {
        boolean equals(Object obj);

        int hashCode();
    }

    private void evictOverdueObjectsUnlock() {
        RefCounted refCounted;
        if (this.mEvictThrottler.a()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<RefCounted> arrayList = new ArrayList<>();
            synchronized (this.mDequeMap) {
                Iterator<Deque<T>> it2 = this.mDequeMap.values().iterator();
                while (it2.hasNext()) {
                    Deque next = it2.next();
                    while (!next.isEmpty() && ((refCounted = (RefCounted) next.peekLast()) == null || elapsedRealtime - refCounted.getLastUsedTimestamp() >= MAX_TIME_OUT)) {
                        next.pollLast();
                        arrayList.add(refCounted);
                    }
                }
            }
            for (RefCounted destroyInstance : arrayList) {
                destroyInstance(destroyInstance);
            }
        }
    }

    private Deque<T> findDequeUnlock(Key key) {
        Deque<T> deque = this.mDequeMap.get(key);
        if (deque != null) {
            return deque;
        }
        LinkedList linkedList = new LinkedList();
        this.mDequeMap.put(key, linkedList);
        return linkedList;
    }

    public static /* synthetic */ void lambda$new$0(FramePool framePool, RefCounted refCounted) {
        if (refCounted != null) {
            synchronized (framePool.mDequeMap) {
                if (framePool.mIsDestroyed) {
                    framePool.destroyInstance(refCounted);
                    return;
                }
                Deque findDequeUnlock = framePool.findDequeUnlock(framePool.keyForObject(refCounted));
                refCounted.updateLastUsedTimestamp(SystemClock.elapsedRealtime());
                findDequeUnlock.addFirst(refCounted);
                framePool.evictOverdueObjectsUnlock();
            }
        }
    }

    public abstract T createInstance(IRecycler<T> iRecycler, Key key);

    public void destroy() {
        this.mIsDestroyed = true;
        evictAll();
    }

    public abstract void destroyInstance(T t11);

    public void evictAll() {
        ArrayList<RefCounted> arrayList = new ArrayList<>();
        synchronized (this.mDequeMap) {
            for (Deque<T> addAll : this.mDequeMap.values()) {
                arrayList.addAll(addAll);
            }
            this.mDequeMap.clear();
        }
        for (RefCounted destroyInstance : arrayList) {
            destroyInstance(destroyInstance);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (!this.mIsDestroyed) {
            LiteavLog.e(TAG, "%s must call destroy() before finalize()!\n%s", getClass().getName(), this.mStackTrace);
        }
    }

    public abstract Key keyForObject(T t11);

    public T obtain(Key key) {
        T t11;
        synchronized (this.mDequeMap) {
            Deque findDequeUnlock = findDequeUnlock(key);
            t11 = !findDequeUnlock.isEmpty() ? (RefCounted) findDequeUnlock.removeFirst() : null;
        }
        evictOverdueObjectsUnlock();
        if (t11 == null) {
            t11 = createInstance(this.mRecycler, key);
        }
        if (t11.retain() != 1) {
            LiteavLog.e(TAG, "invalid reference count for %s", t11);
        }
        return t11;
    }
}
