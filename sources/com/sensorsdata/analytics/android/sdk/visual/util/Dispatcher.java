package com.sensorsdata.analytics.android.sdk.visual.util;

import android.os.Handler;
import android.os.HandlerThread;

public class Dispatcher {
    private static String TAG = "Dispatcher";
    private Handler mHandler;

    public static class DispatchHolder {
        /* access modifiers changed from: private */
        public static final Dispatcher INSTANCE = new Dispatcher();

        private DispatchHolder() {
        }
    }

    public static Dispatcher getInstance() {
        return DispatchHolder.INSTANCE;
    }

    public void post(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public void postDelayed(Runnable runnable, long j11) {
        this.mHandler.removeCallbacks(runnable);
        this.mHandler.postDelayed(runnable, j11);
    }

    public void removeCallbacksAndMessages() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    private Dispatcher() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }
}
