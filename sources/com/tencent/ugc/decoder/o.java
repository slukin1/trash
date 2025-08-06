package com.tencent.ugc.decoder;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50352a;

    private o(UGCVideoDecodeController uGCVideoDecodeController) {
        this.f50352a = uGCVideoDecodeController;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController) {
        return new o(uGCVideoDecodeController);
    }

    public final void run() {
        UGCVideoDecodeController.lambda$abandonDecodingFrames$2(this.f50352a);
    }
}
