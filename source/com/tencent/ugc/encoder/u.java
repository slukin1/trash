package com.tencent.ugc.encoder;

final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50470a;

    private u(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50470a = surfaceInputVideoEncoder;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        return new u(surfaceInputVideoEncoder);
    }

    public final void run() {
        SurfaceInputVideoEncoder.lambda$signalBeforeSwapBuffers$2(this.f50470a);
    }
}
