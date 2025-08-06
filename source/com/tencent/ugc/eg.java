package com.tencent.ugc;

final /* synthetic */ class eg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50406a;

    private eg(UGCMediaListSource uGCMediaListSource) {
        this.f50406a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new eg(uGCMediaListSource);
    }

    public final void run() {
        this.f50406a.loadNextVideoFrameInternal(5);
    }
}
