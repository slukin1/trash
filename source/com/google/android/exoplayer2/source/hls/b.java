package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper.Callback f66018b;

    public /* synthetic */ b(HlsSampleStreamWrapper.Callback callback) {
        this.f66018b = callback;
    }

    public final void run() {
        this.f66018b.onPrepared();
    }
}
