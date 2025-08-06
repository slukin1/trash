package com.tencent.ugc.decoder;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50334a;

    private c(HardwareVideoDecoder hardwareVideoDecoder) {
        this.f50334a = hardwareVideoDecoder;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder) {
        return new c(hardwareVideoDecoder);
    }

    public final void run() {
        this.f50334a.drainAndFeedFrame();
    }
}
