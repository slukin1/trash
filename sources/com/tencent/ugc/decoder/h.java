package com.tencent.ugc.decoder;

import android.view.Surface;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50340a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f50341b;

    private h(HardwareVideoDecoder hardwareVideoDecoder, Surface surface) {
        this.f50340a = hardwareVideoDecoder;
        this.f50341b = surface;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder, Surface surface) {
        return new h(hardwareVideoDecoder, surface);
    }

    public final void run() {
        HardwareVideoDecoder.lambda$setOutputSurface$2(this.f50340a, this.f50341b);
    }
}
