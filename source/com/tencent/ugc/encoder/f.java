package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.HardwareVideoEncoder;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder.AnonymousClass1 f50444a;

    /* renamed from: b  reason: collision with root package name */
    private final EncodedVideoFrame f50445b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50446c;

    private f(HardwareVideoEncoder.AnonymousClass1 r12, EncodedVideoFrame encodedVideoFrame, boolean z11) {
        this.f50444a = r12;
        this.f50445b = encodedVideoFrame;
        this.f50446c = z11;
    }

    public static Runnable a(HardwareVideoEncoder.AnonymousClass1 r12, EncodedVideoFrame encodedVideoFrame, boolean z11) {
        return new f(r12, encodedVideoFrame, z11);
    }

    public final void run() {
        HardwareVideoEncoder.AnonymousClass1.a(this.f50444a, this.f50445b, this.f50446c);
    }
}
