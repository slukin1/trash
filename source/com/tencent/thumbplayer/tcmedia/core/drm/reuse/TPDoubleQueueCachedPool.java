package com.tencent.thumbplayer.tcmedia.core.drm.reuse;

import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TPDoubleQueueCachedPool<T> {
    private static final int DEFAULT_CORE_POOL_SIZE = 2;
    private static final String TAG = "[PlayerCore][TPDoubleQueueCachedPool]";
    private final List<T> mBusyCacheList = new ArrayList();
    private final int mCorePoolSize;
    private final List<T> mIdleCacheList = new ArrayList();
    private ITPObjectLifecycleMgr<T> mObjectLifecycleMgr;

    public interface ITPObjectLifecycleMgr<T> {
        T create(TPDoubleQueueCachedPool<T> tPDoubleQueueCachedPool);

        void release(TPDoubleQueueCachedPool<T> tPDoubleQueueCachedPool, T t11);

        boolean reset(TPDoubleQueueCachedPool<T> tPDoubleQueueCachedPool, T t11);
    }

    public TPDoubleQueueCachedPool(int i11, int i12, ITPObjectLifecycleMgr<T> iTPObjectLifecycleMgr) {
        this.mCorePoolSize = i12 <= 0 ? 2 : i12;
        i11 = i11 <= 0 ? 2 : i11;
        this.mObjectLifecycleMgr = iTPObjectLifecycleMgr;
        for (int i13 = 0; i13 < i11; i13++) {
            T create = iTPObjectLifecycleMgr.create(this);
            if (create == null) {
                TPNativeLog.printLog(3, TAG, "TPDoubleQueueCachedPool, createObject failed.");
            } else {
                this.mIdleCacheList.add(create);
            }
        }
        TPNativeLog.printLog(2, TAG, "TPDoubleQueueCachedPool init size:" + this.mIdleCacheList.size());
    }

    public synchronized T allocObject() {
        T t11;
        if (this.mIdleCacheList.isEmpty()) {
            t11 = this.mObjectLifecycleMgr.create(this);
            if (t11 == null) {
                return null;
            }
        } else {
            t11 = this.mIdleCacheList.remove(0);
        }
        this.mBusyCacheList.add(t11);
        return t11;
    }

    public synchronized void freeObject(T t11) {
        this.mBusyCacheList.remove(t11);
        this.mObjectLifecycleMgr.release(this, t11);
    }

    public synchronized void recycleObject(T t11) {
        if (!this.mBusyCacheList.remove(t11) || this.mIdleCacheList.size() >= this.mCorePoolSize || !this.mObjectLifecycleMgr.reset(this, t11)) {
            this.mObjectLifecycleMgr.release(this, t11);
        } else {
            this.mIdleCacheList.add(t11);
        }
    }

    public synchronized void release() {
        ListIterator<T> listIterator = this.mBusyCacheList.listIterator();
        while (listIterator.hasNext()) {
            this.mObjectLifecycleMgr.release(this, listIterator.next());
            listIterator.remove();
        }
        ListIterator<T> listIterator2 = this.mIdleCacheList.listIterator();
        while (listIterator2.hasNext()) {
            this.mObjectLifecycleMgr.release(this, listIterator2.next());
            listIterator2.remove();
        }
        this.mObjectLifecycleMgr = null;
    }
}
