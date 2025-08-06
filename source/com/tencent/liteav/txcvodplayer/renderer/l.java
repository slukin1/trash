package com.tencent.liteav.txcvodplayer.renderer;

import android.graphics.SurfaceTexture;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22047a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f22048b;

    private l(d dVar, SurfaceTexture surfaceTexture) {
        this.f22047a = dVar;
        this.f22048b = surfaceTexture;
    }

    public static Runnable a(d dVar, SurfaceTexture surfaceTexture) {
        return new l(dVar, surfaceTexture);
    }

    public final void run() {
        d.a(this.f22047a, this.f22048b);
    }
}
