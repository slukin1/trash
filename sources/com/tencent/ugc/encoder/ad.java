package com.tencent.ugc.encoder;

final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50433a;

    private ad(UGCVideoEncodeController uGCVideoEncodeController) {
        this.f50433a = uGCVideoEncodeController;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController) {
        return new ad(uGCVideoEncodeController);
    }

    public final void run() {
        this.f50433a.encodeFrameInternal();
    }
}
