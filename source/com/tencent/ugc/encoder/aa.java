package com.tencent.ugc.encoder;

final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50430a;

    private aa(UGCVideoEncodeController uGCVideoEncodeController) {
        this.f50430a = uGCVideoEncodeController;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController) {
        return new aa(uGCVideoEncodeController);
    }

    public final void run() {
        UGCVideoEncodeController.lambda$stop$1(this.f50430a);
    }
}
