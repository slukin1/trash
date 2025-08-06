package com.tencent.ugc.decoder;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50335a;

    private d(HardwareVideoDecoder hardwareVideoDecoder) {
        this.f50335a = hardwareVideoDecoder;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder) {
        return new d(hardwareVideoDecoder);
    }

    public final void run() {
        this.f50335a.drainAndFeedFrame();
    }
}
