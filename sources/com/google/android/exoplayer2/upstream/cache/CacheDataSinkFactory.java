package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;

@Deprecated
public final class CacheDataSinkFactory implements DataSink.Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long fragmentSize;

    public CacheDataSinkFactory(Cache cache2, long j11) {
        this(cache2, j11, CacheDataSink.DEFAULT_BUFFER_SIZE);
    }

    public DataSink createDataSink() {
        return new CacheDataSink(this.cache, this.fragmentSize, this.bufferSize);
    }

    public CacheDataSinkFactory(Cache cache2, long j11, int i11) {
        this.cache = cache2;
        this.fragmentSize = j11;
        this.bufferSize = i11;
    }
}
