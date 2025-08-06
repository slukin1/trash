package com.tencent.ugc.decoder;

final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50358a;

    private t(UGCVideoDecodeController uGCVideoDecodeController) {
        this.f50358a = uGCVideoDecodeController;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController) {
        return new t(uGCVideoDecodeController);
    }

    public final void run() {
        this.f50358a.notifyDecodeCompleted();
    }
}
