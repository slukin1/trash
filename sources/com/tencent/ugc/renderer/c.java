package com.tencent.ugc.renderer;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceRenderHelper f50766a;

    private c(SurfaceRenderHelper surfaceRenderHelper) {
        this.f50766a = surfaceRenderHelper;
    }

    public static Runnable a(SurfaceRenderHelper surfaceRenderHelper) {
        return new c(surfaceRenderHelper);
    }

    public final void run() {
        SurfaceRenderHelper.lambda$checkViewAvailability$2(this.f50766a);
    }
}
