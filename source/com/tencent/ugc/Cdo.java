package com.tencent.ugc;

import java.util.concurrent.Callable;

/* renamed from: com.tencent.ugc.do  reason: invalid class name */
final /* synthetic */ class Cdo implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50372a;

    private Cdo(UGCMediaListSource uGCMediaListSource) {
        this.f50372a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new Cdo(uGCMediaListSource);
    }

    public final Object call() {
        return Long.valueOf(this.f50372a.calculateTotalDurationOfClips());
    }
}
