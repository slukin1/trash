package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f66991b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f66992c;

    public /* synthetic */ c(Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f66991b = callable;
        this.f66992c = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$3(this.f66991b, this.f66992c);
    }
}
