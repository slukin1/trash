package com.tencent.liteav.videoproducer.capture;

import android.view.Surface;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VirtualDisplayManager f22611a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f22612b;

    private h(VirtualDisplayManager virtualDisplayManager, Surface surface) {
        this.f22611a = virtualDisplayManager;
        this.f22612b = surface;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager, Surface surface) {
        return new h(virtualDisplayManager, surface);
    }

    public final void run() {
        VirtualDisplayManager.a(this.f22611a, this.f22612b);
    }
}
