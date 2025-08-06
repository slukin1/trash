package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f65995b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdPlaybackState f65996c;

    public /* synthetic */ h(AdsMediaSource.ComponentListener componentListener, AdPlaybackState adPlaybackState) {
        this.f65995b = componentListener;
        this.f65996c = adPlaybackState;
    }

    public final void run() {
        this.f65995b.lambda$onAdPlaybackState$0(this.f65996c);
    }
}
