package com.huobi.woodpecker.kalle.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class MainExecutor implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public Handler f21128b = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.f21128b.post(runnable);
    }
}
