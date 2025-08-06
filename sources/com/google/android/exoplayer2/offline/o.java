package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.upstream.cache.CacheWriter;

public final /* synthetic */ class o implements CacheWriter.ProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressiveDownloader f65968a;

    public /* synthetic */ o(ProgressiveDownloader progressiveDownloader) {
        this.f65968a = progressiveDownloader;
    }

    public final void onProgress(long j11, long j12, long j13) {
        this.f65968a.onProgress(j11, j12, j13);
    }
}
