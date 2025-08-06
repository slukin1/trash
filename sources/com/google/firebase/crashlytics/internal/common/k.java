package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f67060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f67061c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67062d;

    public /* synthetic */ k(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        this.f67060b = callable;
        this.f67061c = executor;
        this.f67062d = taskCompletionSource;
    }

    public final void run() {
        Utils.lambda$callTask$3(this.f67060b, this.f67061c, this.f67062d);
    }
}
