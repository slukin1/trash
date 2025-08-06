package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f66993b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f66994c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f66995d;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f66993b = delegatingScheduledExecutorService;
        this.f66994c = callable;
        this.f66995d = completer;
    }

    public final Object call() {
        return this.f66993b.lambda$schedule$4(this.f66994c, this.f66995d);
    }
}
