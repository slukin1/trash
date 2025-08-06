package com.google.android.exoplayer2.upstream.cache;

final class CacheFileMetadata {
    public final long lastTouchTimestamp;
    public final long length;

    public CacheFileMetadata(long j11, long j12) {
        this.length = j11;
        this.lastTouchTimestamp = j12;
    }
}
