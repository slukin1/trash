package com.tencent.ugc;

final /* synthetic */ class du implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50385a;

    private du(UGCMediaListSource uGCMediaListSource) {
        this.f50385a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new du(uGCMediaListSource);
    }

    public final void run() {
        this.f50385a.loadNextVideoFrameInternal(5);
    }
}
