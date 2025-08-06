package com.tencent.ugc;

import java.util.concurrent.FutureTask;

final /* synthetic */ class ds implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50381a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50382b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask f50383c;

    private ds(UGCMediaListSource uGCMediaListSource, int i11, FutureTask futureTask) {
        this.f50381a = uGCMediaListSource;
        this.f50382b = i11;
        this.f50383c = futureTask;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, int i11, FutureTask futureTask) {
        return new ds(uGCMediaListSource, i11, futureTask);
    }

    public final void run() {
        UGCMediaListSource.lambda$setPictureTransition$7(this.f50381a, this.f50382b, this.f50383c);
    }
}
