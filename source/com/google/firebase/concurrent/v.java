package com.google.firebase.concurrent;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LimitedConcurrencyExecutor f67032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f67033c;

    public /* synthetic */ v(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        this.f67032b = limitedConcurrencyExecutor;
        this.f67033c = runnable;
    }

    public final void run() {
        this.f67032b.lambda$decorate$0(this.f67033c);
    }
}
