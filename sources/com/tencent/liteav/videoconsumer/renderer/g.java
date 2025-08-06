package com.tencent.liteav.videoconsumer.renderer;

import android.view.SurfaceView;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f22436a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceView f22437b;

    private g(f fVar, SurfaceView surfaceView) {
        this.f22436a = fVar;
        this.f22437b = surfaceView;
    }

    public static Runnable a(f fVar, SurfaceView surfaceView) {
        return new g(fVar, surfaceView);
    }

    public final void run() {
        f.a(this.f22436a, this.f22437b);
    }
}
