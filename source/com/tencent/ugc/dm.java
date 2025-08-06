package com.tencent.ugc;

final /* synthetic */ class dm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50368a;

    private dm(UGCMediaListSource uGCMediaListSource) {
        this.f50368a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dm(uGCMediaListSource);
    }

    public final void run() {
        this.f50368a.uninitializeInternal();
    }
}
