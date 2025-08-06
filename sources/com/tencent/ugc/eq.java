package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class eq implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50482a;

    private eq(UGCMediaListSource uGCMediaListSource) {
        this.f50482a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new eq(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50482a.calculateTotalDurationOfClips());
    }
}
