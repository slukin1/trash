package com.tencent.ugc;

final /* synthetic */ class ha implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50590a;

    private ha(UGCVideoProcessor uGCVideoProcessor) {
        this.f50590a = uGCVideoProcessor;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor) {
        return new ha(uGCVideoProcessor);
    }

    public final void run() {
        UGCVideoProcessor.lambda$unInitialize$0(this.f50590a);
    }
}
