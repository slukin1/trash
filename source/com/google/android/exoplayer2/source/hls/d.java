package com.google.android.exoplayer2.source.hls;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper f66020b;

    public /* synthetic */ d(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.f66020b = hlsSampleStreamWrapper;
    }

    public final void run() {
        this.f66020b.maybeFinishPrepare();
    }
}
