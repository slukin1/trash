package com.tencent.ugc;

final /* synthetic */ class dw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50388a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50389b;

    private dw(UGCMediaListSource uGCMediaListSource, boolean z11) {
        this.f50388a = uGCMediaListSource;
        this.f50389b = z11;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, boolean z11) {
        return new dw(uGCMediaListSource, z11);
    }

    public final void run() {
        UGCMediaListSource.lambda$seekTo$11(this.f50388a, this.f50389b);
    }
}
