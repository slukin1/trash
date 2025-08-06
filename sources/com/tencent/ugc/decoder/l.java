package com.tencent.ugc.decoder;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50347a;

    /* renamed from: b  reason: collision with root package name */
    private final UGCVideoDecodeControllerListener f50348b;

    private l(UGCVideoDecodeController uGCVideoDecodeController, UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener) {
        this.f50347a = uGCVideoDecodeController;
        this.f50348b = uGCVideoDecodeControllerListener;
    }

    public static Runnable a(UGCVideoDecodeController uGCVideoDecodeController, UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener) {
        return new l(uGCVideoDecodeController, uGCVideoDecodeControllerListener);
    }

    public final void run() {
        this.f50347a.mListener = this.f50348b;
    }
}
