package com.tencent.ugc.renderer;

import android.view.SurfaceView;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceViewRenderHelper f50767a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceView f50768b;

    private d(SurfaceViewRenderHelper surfaceViewRenderHelper, SurfaceView surfaceView) {
        this.f50767a = surfaceViewRenderHelper;
        this.f50768b = surfaceView;
    }

    public static Runnable a(SurfaceViewRenderHelper surfaceViewRenderHelper, SurfaceView surfaceView) {
        return new d(surfaceViewRenderHelper, surfaceView);
    }

    public final void run() {
        SurfaceViewRenderHelper.lambda$new$0(this.f50767a, this.f50768b);
    }
}
