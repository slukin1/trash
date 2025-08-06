package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f66038b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f66039c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f66040d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f66041e;

    public /* synthetic */ l(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.f66038b = eventDispatcher;
        this.f66039c = mediaSourceEventListener;
        this.f66040d = mediaPeriodId;
        this.f66041e = mediaLoadData;
    }

    public final void run() {
        this.f66038b.lambda$upstreamDiscarded$4(this.f66039c, this.f66040d, this.f66041e);
    }
}
