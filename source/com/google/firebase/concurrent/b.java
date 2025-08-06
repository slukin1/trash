package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f66986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f66987b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f66988c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f66989d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f66990e;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        this.f66986a = delegatingScheduledExecutorService;
        this.f66987b = runnable;
        this.f66988c = j11;
        this.f66989d = j12;
        this.f66990e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f66986a.lambda$scheduleAtFixedRate$8(this.f66987b, this.f66988c, this.f66989d, this.f66990e, completer);
    }
}
