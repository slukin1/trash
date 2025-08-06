package com.tencent.ugc.decoder;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50337a;

    private f(HardwareVideoDecoder hardwareVideoDecoder) {
        this.f50337a = hardwareVideoDecoder;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder) {
        return new f(hardwareVideoDecoder);
    }

    public final void run() {
        this.f50337a.abandonDecodingFramesInternal();
    }
}
