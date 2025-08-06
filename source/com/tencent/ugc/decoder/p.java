package com.tencent.ugc.decoder;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50353a;

    private p(UGCVideoDecodeController uGCVideoDecodeController) {
        this.f50353a = uGCVideoDecodeController;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController) {
        return new p(uGCVideoDecodeController);
    }

    public final void run() {
        UGCVideoDecodeController.lambda$signalEndOfStream$3(this.f50353a);
    }
}
