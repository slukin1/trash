package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f67015b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f67016c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f67017d;

    public /* synthetic */ j(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f67015b = delegatingScheduledExecutorService;
        this.f67016c = runnable;
        this.f67017d = completer;
    }

    public final void run() {
        this.f67015b.lambda$scheduleWithFixedDelay$10(this.f67016c, this.f67017d);
    }
}
