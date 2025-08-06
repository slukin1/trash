package com.tencent.android.mipush;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f40467a;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f40468b;

    /* renamed from: com.tencent.android.mipush.a$a  reason: collision with other inner class name */
    public static class C0544a {

        /* renamed from: a  reason: collision with root package name */
        public static a f40469a = new a();
    }

    public static a a() {
        b();
        return C0544a.f40469a;
    }

    private static void b() {
        try {
            HandlerThread handlerThread = f40467a;
            if (handlerThread == null || !handlerThread.isAlive() || f40467a.isInterrupted() || f40467a.getState() == Thread.State.TERMINATED) {
                HandlerThread handlerThread2 = new HandlerThread("tpns.xiaomi.thread");
                f40467a = handlerThread2;
                handlerThread2.start();
                Looper looper = f40467a.getLooper();
                if (looper != null) {
                    f40468b = new Handler(looper);
                } else {
                    Log.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th2) {
            Log.e("CommonWorkingThread", "unexpected for initHandler", th2);
        }
    }

    private a() {
    }

    public boolean a(Runnable runnable) {
        Handler handler = f40468b;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }
}
