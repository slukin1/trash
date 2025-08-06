package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f67012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f67013c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f67014d;

    public /* synthetic */ i(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f67012b = delegatingScheduledExecutorService;
        this.f67013c = runnable;
        this.f67014d = completer;
    }

    public final void run() {
        this.f67012b.lambda$scheduleAtFixedRate$7(this.f67013c, this.f67014d);
    }
}
