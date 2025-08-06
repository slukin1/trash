package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f66029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f66030c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f66031d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f66032e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f66033f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f66034g;

    public /* synthetic */ j(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.f66029b = eventDispatcher;
        this.f66030c = mediaSourceEventListener;
        this.f66031d = loadEventInfo;
        this.f66032e = mediaLoadData;
        this.f66033f = iOException;
        this.f66034g = z11;
    }

    public final void run() {
        this.f66029b.lambda$loadError$3(this.f66030c, this.f66031d, this.f66032e, this.f66033f, this.f66034g);
    }
}
