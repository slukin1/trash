package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f66025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f66026c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f66027d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f66028e;

    public /* synthetic */ i(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f66025b = eventDispatcher;
        this.f66026c = mediaSourceEventListener;
        this.f66027d = loadEventInfo;
        this.f66028e = mediaLoadData;
    }

    public final void run() {
        this.f66025b.lambda$loadCanceled$2(this.f66026c, this.f66027d, this.f66028e);
    }
}
