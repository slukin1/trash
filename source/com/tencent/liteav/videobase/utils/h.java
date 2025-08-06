package com.tencent.liteav.videobase.utils;

import android.graphics.SurfaceTexture;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceTextureHolder f22275a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f22276b;

    private h(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        this.f22275a = surfaceTextureHolder;
        this.f22276b = surfaceTexture;
    }

    public static Runnable a(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        return new h(surfaceTextureHolder, surfaceTexture);
    }

    public final void run() {
        SurfaceTextureHolder.lambda$onFrameAvailable$0(this.f22275a, this.f22276b);
    }
}
