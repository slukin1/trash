package com.tencent.ugc;

final /* synthetic */ class ef implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50405a;

    private ef(UGCMediaListSource uGCMediaListSource) {
        this.f50405a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new ef(uGCMediaListSource);
    }

    public final void run() {
        this.f50405a.loadNextVideoFrameInternal(5);
    }
}
