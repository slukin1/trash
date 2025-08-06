package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource f65986b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f65987c;

    public /* synthetic */ d(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener) {
        this.f65986b = adsMediaSource;
        this.f65987c = componentListener;
    }

    public final void run() {
        this.f65986b.lambda$prepareSourceInternal$0(this.f65987c);
    }
}
