package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.HardwareVideoEncoder;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder.AnonymousClass1 f50448a;

    private h(HardwareVideoEncoder.AnonymousClass1 r12) {
        this.f50448a = r12;
    }

    public static Runnable a(HardwareVideoEncoder.AnonymousClass1 r12) {
        return new h(r12);
    }

    public final void run() {
        HardwareVideoEncoder.AnonymousClass1.a(this.f50448a);
    }
}
