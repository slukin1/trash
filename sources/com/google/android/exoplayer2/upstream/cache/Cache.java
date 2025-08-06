package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;

public interface Cache {
    public static final long UID_UNSET = -1;

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th2) {
            super(th2);
        }

        public CacheException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public interface Listener {
        void onSpanAdded(Cache cache, CacheSpan cacheSpan);

        void onSpanRemoved(Cache cache, CacheSpan cacheSpan);

        void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);
    }

    NavigableSet<CacheSpan> addListener(String str, Listener listener);

    void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) throws CacheException;

    void commitFile(File file, long j11) throws CacheException;

    long getCacheSpace();

    long getCachedBytes(String str, long j11, long j12);

    long getCachedLength(String str, long j11, long j12);

    NavigableSet<CacheSpan> getCachedSpans(String str);

    ContentMetadata getContentMetadata(String str);

    Set<String> getKeys();

    long getUid();

    boolean isCached(String str, long j11, long j12);

    void release();

    void releaseHoleSpan(CacheSpan cacheSpan);

    void removeListener(String str, Listener listener);

    void removeResource(String str);

    void removeSpan(CacheSpan cacheSpan);

    File startFile(String str, long j11, long j12) throws CacheException;

    CacheSpan startReadWrite(String str, long j11, long j12) throws InterruptedException, CacheException;

    CacheSpan startReadWriteNonBlocking(String str, long j11, long j12) throws CacheException;
}
