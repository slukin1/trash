package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class z implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f67038b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f67039c;

    public /* synthetic */ z(Runnable runnable, Object obj) {
        this.f67038b = runnable;
        this.f67039c = obj;
    }

    public final Object call() {
        return this.f67038b.run();
    }
}
