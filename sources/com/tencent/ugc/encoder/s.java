package com.tencent.ugc.encoder;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50464a;

    private s(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50464a = surfaceInputVideoEncoder;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        return new s(surfaceInputVideoEncoder);
    }

    public final void run() {
        SurfaceInputVideoEncoder.lambda$new$0(this.f50464a);
    }
}
