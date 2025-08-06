package com.tencent.ugc;

final /* synthetic */ class gu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50574a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50575b;

    private gu(UGCVideoProcessor uGCVideoProcessor, float f11) {
        this.f50574a = uGCVideoProcessor;
        this.f50575b = f11;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, float f11) {
        return new gu(uGCVideoProcessor, f11);
    }

    public final void run() {
        this.f50574a.mVideoProcessManager.setSpecialRatio(this.f50575b);
    }
}
