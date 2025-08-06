package com.tencent.ugc.encoder;

final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50431a;

    private ab(UGCVideoEncodeController uGCVideoEncodeController) {
        this.f50431a = uGCVideoEncodeController;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController) {
        return new ab(uGCVideoEncodeController);
    }

    public final void run() {
        this.f50431a.encodeFrameInternal();
    }
}
