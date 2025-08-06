package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.BandwidthMeter;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener f66073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f66074c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f66075d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f66076e;

    public /* synthetic */ b(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i11, long j11, long j12) {
        this.f66073b = handlerAndListener;
        this.f66074c = i11;
        this.f66075d = j11;
        this.f66076e = j12;
    }

    public final void run() {
        this.f66073b.listener.onBandwidthSample(this.f66074c, this.f66075d, this.f66076e);
    }
}
