package com.tencent.ugc.decoder;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50357a;

    private s(UGCVideoDecodeController uGCVideoDecodeController) {
        this.f50357a = uGCVideoDecodeController;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController) {
        return new s(uGCVideoDecodeController);
    }

    public final void run() {
        this.f50357a.notifyAbandonDecodingFramesCompleted();
    }
}
