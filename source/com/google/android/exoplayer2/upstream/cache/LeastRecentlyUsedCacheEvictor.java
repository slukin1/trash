package com.google.android.exoplayer2.upstream.cache;

import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    private long currentSize;
    private final TreeSet<CacheSpan> leastRecentlyUsed = new TreeSet<>(d.f66079b);
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j11) {
        this.maxBytes = j11;
    }

    /* access modifiers changed from: private */
    public static int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j11 = cacheSpan.lastTouchTimestamp;
        long j12 = cacheSpan2.lastTouchTimestamp;
        if (j11 - j12 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return j11 < j12 ? -1 : 1;
    }

    private void evictCache(Cache cache, long j11) {
        while (this.currentSize + j11 > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            cache.removeSpan(this.leastRecentlyUsed.first());
        }
    }

    public void onCacheInitialized() {
    }

    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0);
    }

    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    public void onStartFile(Cache cache, String str, long j11, long j12) {
        if (j12 != -1) {
            evictCache(cache, j12);
        }
    }

    public boolean requiresCacheSpanTouches() {
        return true;
    }
}
