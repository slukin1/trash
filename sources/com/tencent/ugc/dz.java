package com.tencent.ugc;

import java.util.List;
import java.util.concurrent.FutureTask;

final /* synthetic */ class dz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50392a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50393b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask f50394c;

    private dz(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask) {
        this.f50392a = uGCMediaListSource;
        this.f50393b = list;
        this.f50394c = futureTask;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask) {
        return new dz(uGCMediaListSource, list, futureTask);
    }

    public final void run() {
        UGCMediaListSource.lambda$setRepeatPlay$12(this.f50392a, this.f50393b, this.f50394c);
    }
}
