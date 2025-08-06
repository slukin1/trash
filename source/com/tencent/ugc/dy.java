package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class dy implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50391a;

    private dy(UGCMediaListSource uGCMediaListSource) {
        this.f50391a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dy(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50391a.calculateTotalDurationOfClips());
    }
}
