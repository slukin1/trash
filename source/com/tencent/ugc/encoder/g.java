package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.HardwareVideoEncoder;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder.AnonymousClass1 f50447a;

    private g(HardwareVideoEncoder.AnonymousClass1 r12) {
        this.f50447a = r12;
    }

    public static Runnable a(HardwareVideoEncoder.AnonymousClass1 r12) {
        return new g(r12);
    }

    public final void run() {
        HardwareVideoEncoder.AnonymousClass1.b(this.f50447a);
    }
}
