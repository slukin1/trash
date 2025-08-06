package com.tencent.ugc;

import java.util.List;
import java.util.concurrent.FutureTask;

final /* synthetic */ class el implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50412a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50413b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask f50414c;

    /* renamed from: d  reason: collision with root package name */
    private final FutureTask f50415d;

    private el(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask, FutureTask futureTask2) {
        this.f50412a = uGCMediaListSource;
        this.f50413b = list;
        this.f50414c = futureTask;
        this.f50415d = futureTask2;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask, FutureTask futureTask2) {
        return new el(uGCMediaListSource, list, futureTask, futureTask2);
    }

    public final void run() {
        UGCMediaListSource.lambda$setVideoSources$0(this.f50412a, this.f50413b, this.f50414c, this.f50415d);
    }
}
