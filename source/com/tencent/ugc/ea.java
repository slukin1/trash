package com.tencent.ugc;

final /* synthetic */ class ea implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50397a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50398b;

    private ea(UGCMediaListSource uGCMediaListSource, boolean z11) {
        this.f50397a = uGCMediaListSource;
        this.f50398b = z11;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, boolean z11) {
        return new ea(uGCMediaListSource, z11);
    }

    public final void run() {
        UGCMediaListSource.lambda$setReverse$13(this.f50397a, this.f50398b);
    }
}
