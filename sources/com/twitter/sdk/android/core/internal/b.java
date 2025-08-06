package com.twitter.sdk.android.core.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51187b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f51188c;

    public /* synthetic */ b(String str, AtomicLong atomicLong) {
        this.f51187b = str;
        this.f51188c = atomicLong;
    }

    public final Thread newThread(Runnable runnable) {
        return ExecutorUtils.lambda$getNamedThreadFactory$0(this.f51187b, this.f51188c, runnable);
    }
}
