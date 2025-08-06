package com.tencent.ugc.decoder;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50336a;

    private e(HardwareVideoDecoder hardwareVideoDecoder) {
        this.f50336a = hardwareVideoDecoder;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder) {
        return new e(hardwareVideoDecoder);
    }

    public final void run() {
        this.f50336a.stopInternal();
    }
}
