package com.tencent.liteav.videoproducer.capture;

import android.media.projection.MediaProjection;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VirtualDisplayManager f22613a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaProjection f22614b;

    private i(VirtualDisplayManager virtualDisplayManager, MediaProjection mediaProjection) {
        this.f22613a = virtualDisplayManager;
        this.f22614b = mediaProjection;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager, MediaProjection mediaProjection) {
        return new i(virtualDisplayManager, mediaProjection);
    }

    public final void run() {
        VirtualDisplayManager.a(this.f22613a, this.f22614b);
    }
}
