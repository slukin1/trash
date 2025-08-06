package com.tencent.ugc.renderer;

import android.view.Surface;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceRenderHelper f50757a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f50758b;

    private a(SurfaceRenderHelper surfaceRenderHelper, Surface surface) {
        this.f50757a = surfaceRenderHelper;
        this.f50758b = surface;
    }

    public static Runnable a(SurfaceRenderHelper surfaceRenderHelper, Surface surface) {
        return new a(surfaceRenderHelper, surface);
    }

    public final void run() {
        SurfaceRenderHelper.lambda$new$0(this.f50757a, this.f50758b);
    }
}
