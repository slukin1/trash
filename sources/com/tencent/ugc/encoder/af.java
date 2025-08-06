package com.tencent.ugc.encoder;

final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50435a;

    private af(UGCVideoEncodeController uGCVideoEncodeController) {
        this.f50435a = uGCVideoEncodeController;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController) {
        return new af(uGCVideoEncodeController);
    }

    public final void run() {
        this.f50435a.encodeFrameInternal();
    }
}
