package com.tencent.ugc.renderer;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceRenderHelper f50765a;

    private b(SurfaceRenderHelper surfaceRenderHelper) {
        this.f50765a = surfaceRenderHelper;
    }

    public static Runnable a(SurfaceRenderHelper surfaceRenderHelper) {
        return new b(surfaceRenderHelper);
    }

    public final void run() {
        SurfaceRenderHelper.lambda$release$1(this.f50765a);
    }
}
