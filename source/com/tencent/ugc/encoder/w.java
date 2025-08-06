package com.tencent.ugc.encoder;

final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50472a;

    private w(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50472a = surfaceInputVideoEncoder;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        return new w(surfaceInputVideoEncoder);
    }

    public final void run() {
        SurfaceInputVideoEncoder.lambda$stopSync$4(this.f50472a);
    }
}
