package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class ei implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50408a;

    private ei(UGCMediaListSource uGCMediaListSource) {
        this.f50408a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new ei(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50408a.calculateTotalDurationOfClips());
    }
}
