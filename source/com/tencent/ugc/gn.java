package com.tencent.ugc;

final /* synthetic */ class gn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50560a;

    private gn(UGCVideoProcessor uGCVideoProcessor) {
        this.f50560a = uGCVideoProcessor;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor) {
        return new gn(uGCVideoProcessor);
    }

    public final void run() {
        this.f50560a.onCompleteBroadcast();
    }
}
