package com.tencent.ugc.videobase.frame;

import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class RefCounted {
    private static final String TAG = "RefCounted";
    private static final a sThrottler = new a(TimeUnit.SECONDS.toMillis(1));
    private long mLastUsedTimestamp = -1;
    private final IRecycler mRecycler;
    private final AtomicInteger mRefCnt = new AtomicInteger(0);
    private String mStackTrace;

    public RefCounted(IRecycler iRecycler) {
        this.mRecycler = iRecycler;
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.mRecycler != null && this.mRefCnt.get() != 0) {
            LiteavLog.e(sThrottler, TAG, "Object's reference count(%d) isn't zero when finalize.\n retainTrack:%s", Integer.valueOf(this.mRefCnt.get()), this.mStackTrace);
        }
    }

    public long getLastUsedTimestamp() {
        return this.mLastUsedTimestamp;
    }

    public void release() {
        IRecycler iRecycler;
        if (this.mRefCnt.decrementAndGet() == 0 && (iRecycler = this.mRecycler) != null) {
            iRecycler.recycle(this);
        }
    }

    public int retain() {
        this.mStackTrace = null;
        return this.mRefCnt.addAndGet(1);
    }

    public void updateLastUsedTimestamp(long j11) {
        this.mLastUsedTimestamp = j11;
    }
}
