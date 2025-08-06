package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f65875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f65876c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f65877d;

    public /* synthetic */ p(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.f65875b = eventDispatcher;
        this.f65876c = drmSessionEventListener;
        this.f65877d = exc;
    }

    public final void run() {
        this.f65875b.lambda$drmSessionManagerError$2(this.f65876c, this.f65877d);
    }
}
