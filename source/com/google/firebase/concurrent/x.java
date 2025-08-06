package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class x implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f67036c;

    public /* synthetic */ x(Runnable runnable, Object obj) {
        this.f67035b = runnable;
        this.f67036c = obj;
    }

    public final Object call() {
        return this.f67035b.run();
    }
}
