package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class dx implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50390a;

    private dx(UGCMediaListSource uGCMediaListSource) {
        this.f50390a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dx(uGCMediaListSource);
    }

    public final Object call() {
        return Boolean.valueOf(this.f50390a.hasAudioDataInternal());
    }
}
