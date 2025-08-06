package com.twitter.sdk.android.core.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f51183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f51184c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f51185d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f51186e;

    public /* synthetic */ a(ExecutorService executorService, long j11, TimeUnit timeUnit, String str) {
        this.f51183b = executorService;
        this.f51184c = j11;
        this.f51185d = timeUnit;
        this.f51186e = str;
    }

    public final void run() {
        ExecutorUtils.lambda$addDelayedShutdownHook$1(this.f51183b, this.f51184c, this.f51185d, this.f51186e);
    }
}
