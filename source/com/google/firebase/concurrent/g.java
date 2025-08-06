package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class g implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f67005a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f67006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f67007c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f67008d;

    public /* synthetic */ g(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, long j11, TimeUnit timeUnit) {
        this.f67005a = delegatingScheduledExecutorService;
        this.f67006b = callable;
        this.f67007c = j11;
        this.f67008d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f67005a.lambda$schedule$5(this.f67006b, this.f67007c, this.f67008d, completer);
    }
}
