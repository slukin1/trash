package com.tencent.tpns.baseapi.base.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.lang.Thread;

public class CommonWorkingThread {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f49821a;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f49822b;

    public static class CommonWorkingThreadHolder {
        public static CommonWorkingThread instance = new CommonWorkingThread();
    }

    private static void a() {
        try {
            HandlerThread handlerThread = f49821a;
            if (handlerThread == null || !handlerThread.isAlive() || f49821a.isInterrupted() || f49821a.getState() == Thread.State.TERMINATED) {
                HandlerThread handlerThread2 = new HandlerThread("tpns.baseapi.thread");
                f49821a = handlerThread2;
                handlerThread2.start();
                Looper looper = f49821a.getLooper();
                if (looper != null) {
                    f49822b = new Handler(looper);
                } else {
                    Logger.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th2) {
            Logger.e("CommonWorkingThread", "unexpected for initHandler", th2);
        }
    }

    public static CommonWorkingThread getInstance() {
        a();
        return CommonWorkingThreadHolder.instance;
    }

    public boolean execute(TTask tTask) {
        Handler handler = f49822b;
        if (handler != null) {
            return handler.post(tTask);
        }
        return false;
    }

    public boolean executeAtTime(TTask tTask, int i11, long j11) {
        Handler handler = f49822b;
        if (handler != null) {
            return handler.postAtTime(tTask, Integer.valueOf(i11), SystemClock.uptimeMillis() + j11);
        }
        return false;
    }

    public Handler getHandler() {
        return f49822b;
    }

    public void remove(int i11) {
        Handler handler = f49822b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(Integer.valueOf(i11));
        }
    }

    private CommonWorkingThread() {
    }

    public boolean execute(TTask tTask, long j11) {
        Handler handler = f49822b;
        if (handler != null) {
            return handler.postDelayed(tTask, j11);
        }
        return false;
    }

    public void remove(TTask tTask) {
        Handler handler = f49822b;
        if (handler != null) {
            handler.removeCallbacks(tTask);
        }
    }
}
