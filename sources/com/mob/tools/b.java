package com.mob.tools;

import com.mob.commons.C0891r;
import java.lang.Thread;

public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f27756a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f27757b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f27758c = false;

    private b() {
    }

    public static synchronized void a() {
        synchronized (b.class) {
            if (!f27757b && C0891r.f27328h && !f27758c) {
                f27758c = true;
                f27756a = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new b());
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            MobLog.getInstance().d("UE handled, processing...", new Object[0]);
            MobLog.getInstance().crash(th2);
            uncaughtExceptionHandler = f27756a;
            if (uncaughtExceptionHandler == null || (uncaughtExceptionHandler instanceof b)) {
                return;
            }
        } catch (Throwable th3) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = f27756a;
            if (uncaughtExceptionHandler2 != null && !(uncaughtExceptionHandler2 instanceof b)) {
                uncaughtExceptionHandler2.uncaughtException(thread, th2);
            }
            throw th3;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }
}
