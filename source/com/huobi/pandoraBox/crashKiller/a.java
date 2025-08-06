package com.huobi.pandoraBox.crashKiller;

import java.lang.Thread;

public final /* synthetic */ class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f80301b = new a();

    public final void uncaughtException(Thread thread, Throwable th2) {
        CrashKiller.e(thread, th2);
    }
}
