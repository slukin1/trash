package com.tencent.ugc;

final /* synthetic */ class gg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50548a;

    private gg(UGCMediaListSource uGCMediaListSource) {
        this.f50548a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new gg(uGCMediaListSource);
    }

    public final void run() {
        this.f50548a.initialize();
    }
}
