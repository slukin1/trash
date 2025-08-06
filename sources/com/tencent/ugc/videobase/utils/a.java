package com.tencent.ugc.videobase.utils;

import android.graphics.SurfaceTexture;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceTextureHolder f50871a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f50872b;

    private a(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        this.f50871a = surfaceTextureHolder;
        this.f50872b = surfaceTexture;
    }

    public static Runnable a(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        return new a(surfaceTextureHolder, surfaceTexture);
    }

    public final void run() {
        SurfaceTextureHolder.lambda$onFrameAvailable$0(this.f50871a, this.f50872b);
    }
}
