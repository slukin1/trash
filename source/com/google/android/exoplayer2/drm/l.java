package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f65866b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f65867c;

    public /* synthetic */ l(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f65866b = eventDispatcher;
        this.f65867c = drmSessionEventListener;
    }

    public final void run() {
        this.f65866b.lambda$drmKeysRemoved$4(this.f65867c);
    }
}
