package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.UGCVideoEncodeController;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;

final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController.AnonymousClass1 f50436a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50437b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedVideoFrame f50438c;

    private ag(UGCVideoEncodeController.AnonymousClass1 r12, boolean z11, EncodedVideoFrame encodedVideoFrame) {
        this.f50436a = r12;
        this.f50437b = z11;
        this.f50438c = encodedVideoFrame;
    }

    public static Runnable a(UGCVideoEncodeController.AnonymousClass1 r12, boolean z11, EncodedVideoFrame encodedVideoFrame) {
        return new ag(r12, z11, encodedVideoFrame);
    }

    public final void run() {
        UGCVideoEncodeController.AnonymousClass1.a(this.f50436a, this.f50437b, this.f50438c);
    }
}
