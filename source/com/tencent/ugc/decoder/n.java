package com.tencent.ugc.decoder;

import com.tencent.ugc.videobase.common.EncodedVideoFrame;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50350a;

    /* renamed from: b  reason: collision with root package name */
    private final EncodedVideoFrame f50351b;

    private n(UGCVideoDecodeController uGCVideoDecodeController, EncodedVideoFrame encodedVideoFrame) {
        this.f50350a = uGCVideoDecodeController;
        this.f50351b = encodedVideoFrame;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController, EncodedVideoFrame encodedVideoFrame) {
        return new n(uGCVideoDecodeController, encodedVideoFrame);
    }

    public final void run() {
        UGCVideoDecodeController.lambda$decode$1(this.f50350a, this.f50351b);
    }
}
