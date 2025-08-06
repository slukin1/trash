package com.tencent.ugc;

import java.util.List;
import java.util.concurrent.FutureTask;

final /* synthetic */ class ec implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50400a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50401b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask f50402c;

    private ec(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask) {
        this.f50400a = uGCMediaListSource;
        this.f50401b = list;
        this.f50402c = futureTask;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask) {
        return new ec(uGCMediaListSource, list, futureTask);
    }

    public final void run() {
        UGCMediaListSource.lambda$setSpeedList$14(this.f50400a, this.f50401b, this.f50402c);
    }
}
