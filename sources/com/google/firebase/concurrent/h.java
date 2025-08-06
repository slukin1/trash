package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f67009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f67010c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f67011d;

    public /* synthetic */ h(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f67009b = delegatingScheduledExecutorService;
        this.f67010c = runnable;
        this.f67011d = completer;
    }

    public final void run() {
        this.f67009b.lambda$schedule$1(this.f67010c, this.f67011d);
    }
}
