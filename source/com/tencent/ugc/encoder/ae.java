package com.tencent.ugc.encoder;

final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50434a;

    private ae(UGCVideoEncodeController uGCVideoEncodeController) {
        this.f50434a = uGCVideoEncodeController;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController) {
        return new ae(uGCVideoEncodeController);
    }

    public final void run() {
        this.f50434a.encodeFrameInternal();
    }
}
