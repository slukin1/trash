package com.tencent.ugc;

final /* synthetic */ class hc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50594a;

    private hc(UGCVideoProcessor uGCVideoProcessor) {
        this.f50594a = uGCVideoProcessor;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor) {
        return new hc(uGCVideoProcessor);
    }

    public final void run() {
        this.f50594a.stopEncoder();
    }
}
