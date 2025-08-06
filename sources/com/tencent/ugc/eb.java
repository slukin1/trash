package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class eb implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50399a;

    private eb(UGCMediaListSource uGCMediaListSource) {
        this.f50399a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new eb(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50399a.calculateTotalDurationOfClips());
    }
}
