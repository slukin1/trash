package com.tencent.ugc;

final /* synthetic */ class ej implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50409a;

    private ej(UGCMediaListSource uGCMediaListSource) {
        this.f50409a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new ej(uGCMediaListSource);
    }

    public final void run() {
        this.f50409a.prePareNextUGCPixelFrameProvider();
    }
}
