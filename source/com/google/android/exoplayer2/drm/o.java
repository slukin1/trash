package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f65872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f65873c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f65874d;

    public /* synthetic */ o(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i11) {
        this.f65872b = eventDispatcher;
        this.f65873c = drmSessionEventListener;
        this.f65874d = i11;
    }

    public final void run() {
        this.f65872b.lambda$drmSessionAcquired$0(this.f65873c, this.f65874d);
    }
}
