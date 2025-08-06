package com.tencent.ugc.encoder;

final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50471a;

    private v(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50471a = surfaceInputVideoEncoder;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        return new v(surfaceInputVideoEncoder);
    }

    public final void run() {
        SurfaceInputVideoEncoder.lambda$signalEndOfStream$3(this.f50471a);
    }
}
