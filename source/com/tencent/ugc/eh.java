package com.tencent.ugc;

final /* synthetic */ class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50407a;

    private eh(UGCMediaListSource uGCMediaListSource) {
        this.f50407a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new eh(uGCMediaListSource);
    }

    public final void run() {
        this.f50407a.prePareNextUGCPixelFrameProvider();
    }
}
