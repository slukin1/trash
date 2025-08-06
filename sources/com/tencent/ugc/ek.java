package com.tencent.ugc;

final /* synthetic */ class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50410a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50411b;

    private ek(UGCMediaListSource uGCMediaListSource, int i11) {
        this.f50410a = uGCMediaListSource;
        this.f50411b = i11;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, int i11) {
        return new ek(uGCMediaListSource, i11);
    }

    public final void run() {
        this.f50410a.mTailWaterMarkDurationMs = ((long) this.f50411b) * 1000;
    }
}
