package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.AdPrepareListener f65990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f65991c;

    public /* synthetic */ f(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f65990b = adPrepareListener;
        this.f65991c = mediaPeriodId;
    }

    public final void run() {
        this.f65990b.lambda$onPrepareComplete$0(this.f65991c);
    }
}
