package com.tencent.ugc.encoder;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder f50443a;

    private e(HardwareVideoEncoder hardwareVideoEncoder) {
        this.f50443a = hardwareVideoEncoder;
    }

    public static Runnable a(HardwareVideoEncoder hardwareVideoEncoder) {
        return new e(hardwareVideoEncoder);
    }

    public final void run() {
        HardwareVideoEncoder.lambda$uninitialize$2(this.f50443a);
    }
}
