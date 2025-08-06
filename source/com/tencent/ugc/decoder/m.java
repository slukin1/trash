package com.tencent.ugc.decoder;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50349a;

    private m(UGCVideoDecodeController uGCVideoDecodeController) {
        this.f50349a = uGCVideoDecodeController;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController) {
        return new m(uGCVideoDecodeController);
    }

    public final void run() {
        this.f50349a.stopInternal();
    }
}
