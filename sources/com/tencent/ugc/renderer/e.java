package com.tencent.ugc.renderer;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceViewRenderHelper f50769a;

    private e(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        this.f50769a = surfaceViewRenderHelper;
    }

    public static Runnable a(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        return new e(surfaceViewRenderHelper);
    }

    public final void run() {
        SurfaceViewRenderHelper.lambda$release$1(this.f50769a);
    }
}
