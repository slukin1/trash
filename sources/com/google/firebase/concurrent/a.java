package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomThreadFactory f66984b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f66985c;

    public /* synthetic */ a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        this.f66984b = customThreadFactory;
        this.f66985c = runnable;
    }

    public final void run() {
        this.f66984b.lambda$newThread$0(this.f66985c);
    }
}
