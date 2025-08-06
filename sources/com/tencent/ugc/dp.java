package com.tencent.ugc;

import java.util.concurrent.FutureTask;

final /* synthetic */ class dp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50373a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50374b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50375c;

    /* renamed from: d  reason: collision with root package name */
    private final FutureTask f50376d;

    private dp(UGCMediaListSource uGCMediaListSource, long j11, long j12, FutureTask futureTask) {
        this.f50373a = uGCMediaListSource;
        this.f50374b = j11;
        this.f50375c = j12;
        this.f50376d = futureTask;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, long j11, long j12, FutureTask futureTask) {
        return new dp(uGCMediaListSource, j11, j12, futureTask);
    }

    public final void run() {
        UGCMediaListSource.lambda$setVideoSourceRange$5(this.f50373a, this.f50374b, this.f50375c, this.f50376d);
    }
}
