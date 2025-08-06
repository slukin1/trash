package com.tencent.ugc.renderer;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceViewRenderHelper f50771a;

    private g(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        this.f50771a = surfaceViewRenderHelper;
    }

    public static Runnable a(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        return new g(surfaceViewRenderHelper);
    }

    public final void run() {
        this.f50771a.updateViewLayoutForHDR();
    }
}
