package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import java.io.IOException;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.AdPrepareListener f65992b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f65993c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f65994d;

    public /* synthetic */ g(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
        this.f65992b = adPrepareListener;
        this.f65993c = mediaPeriodId;
        this.f65994d = iOException;
    }

    public final void run() {
        this.f65992b.lambda$onPrepareError$1(this.f65993c, this.f65994d);
    }
}
