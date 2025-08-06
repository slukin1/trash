package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f66009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f66010c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f66011d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f66012e;

    public /* synthetic */ g(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f66009b = eventDispatcher;
        this.f66010c = mediaSourceEventListener;
        this.f66011d = loadEventInfo;
        this.f66012e = mediaLoadData;
    }

    public final void run() {
        this.f66009b.lambda$loadCompleted$1(this.f66010c, this.f66011d, this.f66012e);
    }
}
