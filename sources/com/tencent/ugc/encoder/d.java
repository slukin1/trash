package com.tencent.ugc.encoder;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder f50441a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50442b;

    private d(HardwareVideoEncoder hardwareVideoEncoder, long j11) {
        this.f50441a = hardwareVideoEncoder;
        this.f50442b = j11;
    }

    public static Runnable a(HardwareVideoEncoder hardwareVideoEncoder, long j11) {
        return new d(hardwareVideoEncoder, j11);
    }

    public final void run() {
        HardwareVideoEncoder.lambda$stopSync$1(this.f50441a, this.f50442b);
    }
}
