package com.tencent.ugc.encoder;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50440a;

    private c(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50440a = surfaceInputVideoEncoder;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        return new c(surfaceInputVideoEncoder);
    }

    public final void run() {
        this.f50440a.signalEndOfStream();
    }
}
