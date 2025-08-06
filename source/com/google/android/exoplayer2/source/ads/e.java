package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource f65988b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f65989c;

    public /* synthetic */ e(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener) {
        this.f65988b = adsMediaSource;
        this.f65989c = componentListener;
    }

    public final void run() {
        this.f65988b.lambda$releaseSourceInternal$1(this.f65989c);
    }
}
