package com.huawei.android.hms.tpns;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;

public class CommonWorkingThread {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f37546a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f37547b;

    public static class CommonWorkingThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        public static CommonWorkingThread f37548a = new CommonWorkingThread();
    }

    public static CommonWorkingThread b() {
        c();
        return CommonWorkingThreadHolder.f37548a;
    }

    public static void c() {
        try {
            HandlerThread handlerThread = f37546a;
            if (handlerThread == null || !handlerThread.isAlive() || f37546a.isInterrupted() || f37546a.getState() == Thread.State.TERMINATED) {
                HandlerThread handlerThread2 = new HandlerThread("tpns.huawei.thread");
                f37546a = handlerThread2;
                handlerThread2.start();
                Looper looper = f37546a.getLooper();
                if (looper != null) {
                    f37547b = new Handler(looper);
                } else {
                    Log.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th2) {
            Log.e("CommonWorkingThread", "unexpected for initHandler", th2);
        }
    }

    public boolean a(Runnable runnable) {
        Handler handler = f37547b;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }

    public CommonWorkingThread() {
    }
}
