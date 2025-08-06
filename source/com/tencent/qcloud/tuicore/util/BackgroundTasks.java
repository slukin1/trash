package com.tencent.qcloud.tuicore.util;

import android.os.Handler;
import android.os.Looper;

public class BackgroundTasks {
    private static final BackgroundTasks instance = new BackgroundTasks();
    private final Handler handler = new Handler(Looper.getMainLooper());

    private BackgroundTasks() {
    }

    public static BackgroundTasks getInstance() {
        return instance;
    }

    public boolean postDelayed(Runnable runnable, long j11) {
        return this.handler.postDelayed(runnable, j11);
    }

    public void runOnUiThread(Runnable runnable) {
        this.handler.post(runnable);
    }
}
