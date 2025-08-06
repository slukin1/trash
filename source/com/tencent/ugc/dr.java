package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class dr implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50380a;

    private dr(UGCMediaListSource uGCMediaListSource) {
        this.f50380a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dr(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50380a.calculateTotalDurationOfClips());
    }
}
