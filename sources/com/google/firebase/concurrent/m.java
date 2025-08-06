package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67022b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f67023c;

    public /* synthetic */ m(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f67022b = runnable;
        this.f67023c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f67022b, this.f67023c);
    }
}
