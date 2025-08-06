package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67018b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f67019c;

    public /* synthetic */ k(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f67018b = runnable;
        this.f67019c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$0(this.f67018b, this.f67019c);
    }
}
