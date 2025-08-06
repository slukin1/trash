package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f65870b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f65871c;

    public /* synthetic */ n(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f65870b = eventDispatcher;
        this.f65871c = drmSessionEventListener;
    }

    public final void run() {
        this.f65870b.lambda$drmKeysRestored$3(this.f65871c);
    }
}
