package com.tencent.ugc.encoder;

final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50432a;

    private ac(UGCVideoEncodeController uGCVideoEncodeController) {
        this.f50432a = uGCVideoEncodeController;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController) {
        return new ac(uGCVideoEncodeController);
    }

    public final void run() {
        this.f50432a.encodeFrameInternal();
    }
}
