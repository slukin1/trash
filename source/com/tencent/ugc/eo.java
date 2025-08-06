package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class eo implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50478a;

    private eo(UGCMediaListSource uGCMediaListSource) {
        this.f50478a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new eo(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50478a.calculateTotalDurationOfClips());
    }
}
