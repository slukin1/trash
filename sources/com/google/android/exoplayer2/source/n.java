package com.google.android.exoplayer2.source;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f66042b;

    public /* synthetic */ n(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.f66042b = progressiveMediaPeriod;
    }

    public final void run() {
        this.f66042b.maybeFinishPrepare();
    }
}
