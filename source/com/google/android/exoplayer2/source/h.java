package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f66013b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f66014c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f66015d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f66016e;

    public /* synthetic */ h(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f66013b = eventDispatcher;
        this.f66014c = mediaSourceEventListener;
        this.f66015d = loadEventInfo;
        this.f66016e = mediaLoadData;
    }

    public final void run() {
        this.f66013b.lambda$loadStarted$0(this.f66014c, this.f66015d, this.f66016e);
    }
}
