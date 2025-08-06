package com.google.android.exoplayer2.source.hls;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper f66019b;

    public /* synthetic */ c(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.f66019b = hlsSampleStreamWrapper;
    }

    public final void run() {
        this.f66019b.onTracksEnded();
    }
}
