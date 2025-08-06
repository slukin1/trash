package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f65868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f65869c;

    public /* synthetic */ m(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f65868b = eventDispatcher;
        this.f65869c = drmSessionEventListener;
    }

    public final void run() {
        this.f65868b.lambda$drmKeysLoaded$1(this.f65869c);
    }
}
