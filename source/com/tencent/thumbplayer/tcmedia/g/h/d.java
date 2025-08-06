package com.tencent.thumbplayer.tcmedia.g.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f49347a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f49348b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    private static final HandlerThread f49349c;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f49350d;

    static {
        HandlerThread handlerThread = new HandlerThread("tmediacodec-sub");
        f49349c = handlerThread;
        handlerThread.start();
        f49350d = new Handler(handlerThread.getLooper());
    }

    public static void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            f49348b.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void b(Runnable runnable) {
        f49350d.post(runnable);
    }
}
