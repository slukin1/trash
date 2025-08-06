package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class w implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67034b;

    public /* synthetic */ w(Runnable runnable) {
        this.f67034b = runnable;
    }

    public final Object call() {
        return this.f67034b.run();
    }
}
