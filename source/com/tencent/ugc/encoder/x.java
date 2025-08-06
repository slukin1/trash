package com.tencent.ugc.encoder;

final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50473a;

    private x(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50473a = surfaceInputVideoEncoder;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        return new x(surfaceInputVideoEncoder);
    }

    public final void run() {
        SurfaceInputVideoEncoder.lambda$uninitialize$5(this.f50473a);
    }
}
