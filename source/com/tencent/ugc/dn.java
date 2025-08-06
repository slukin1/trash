package com.tencent.ugc;

import java.util.concurrent.FutureTask;

final /* synthetic */ class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50369a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50370b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask f50371c;

    private dn(UGCMediaListSource uGCMediaListSource, boolean z11, FutureTask futureTask) {
        this.f50369a = uGCMediaListSource;
        this.f50370b = z11;
        this.f50371c = futureTask;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, boolean z11, FutureTask futureTask) {
        return new dn(uGCMediaListSource, z11, futureTask);
    }

    public final void run() {
        UGCMediaListSource.lambda$setIsSplitScreenMode$4(this.f50369a, this.f50370b, this.f50371c);
    }
}
