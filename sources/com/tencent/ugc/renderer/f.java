package com.tencent.ugc.renderer;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceViewRenderHelper f50770a;

    private f(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        this.f50770a = surfaceViewRenderHelper;
    }

    public static Runnable a(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        return new f(surfaceViewRenderHelper);
    }

    public final void run() {
        SurfaceViewRenderHelper.lambda$checkViewAvailability$2(this.f50770a);
    }
}
