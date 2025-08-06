package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class e implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f66996a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f66997b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f66998c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f66999d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f67000e;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        this.f66996a = delegatingScheduledExecutorService;
        this.f66997b = runnable;
        this.f66998c = j11;
        this.f66999d = j12;
        this.f67000e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f66996a.lambda$scheduleWithFixedDelay$11(this.f66997b, this.f66998c, this.f66999d, this.f67000e, completer);
    }
}
