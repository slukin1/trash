package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67020b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f67021c;

    public /* synthetic */ l(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f67020b = runnable;
        this.f67021c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f67020b, this.f67021c);
    }
}
