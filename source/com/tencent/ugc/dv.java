package com.tencent.ugc;

final /* synthetic */ class dv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50386a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50387b;

    private dv(UGCMediaListSource uGCMediaListSource, long j11) {
        this.f50386a = uGCMediaListSource;
        this.f50387b = j11;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, long j11) {
        return new dv(uGCMediaListSource, j11);
    }

    public final void run() {
        UGCMediaListSource.lambda$setPlayEndTime$10(this.f50386a, this.f50387b);
    }
}
