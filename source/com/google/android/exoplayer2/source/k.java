package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f66035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f66036c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f66037d;

    public /* synthetic */ k(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.f66035b = eventDispatcher;
        this.f66036c = mediaSourceEventListener;
        this.f66037d = mediaLoadData;
    }

    public final void run() {
        this.f66035b.lambda$downstreamFormatChanged$5(this.f66036c, this.f66037d);
    }
}
