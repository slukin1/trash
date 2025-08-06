package com.tencent.ugc.encoder;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder f50439a;

    private b(HardwareVideoEncoder hardwareVideoEncoder) {
        this.f50439a = hardwareVideoEncoder;
    }

    public static Runnable a(HardwareVideoEncoder hardwareVideoEncoder) {
        return new b(hardwareVideoEncoder);
    }

    public final void run() {
        this.f50439a.encodeFrameInternal();
    }
}
