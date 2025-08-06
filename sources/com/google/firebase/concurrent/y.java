package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class y implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67037b;

    public /* synthetic */ y(Runnable runnable) {
        this.f67037b = runnable;
    }

    public final Object call() {
        return this.f67037b.run();
    }
}
