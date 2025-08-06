package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class f implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f67001a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f67003c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f67004d;

    public /* synthetic */ f(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j11, TimeUnit timeUnit) {
        this.f67001a = delegatingScheduledExecutorService;
        this.f67002b = runnable;
        this.f67003c = j11;
        this.f67004d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f67001a.lambda$schedule$2(this.f67002b, this.f67003c, this.f67004d, completer);
    }
}
