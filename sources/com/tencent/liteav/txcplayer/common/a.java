package com.tencent.liteav.txcplayer.common;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f21724a;

    private a() {
        super(1, 3, 100, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    public static synchronized ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (a.class) {
            ThreadPoolExecutor threadPoolExecutor2 = f21724a;
            if (threadPoolExecutor2 == null || threadPoolExecutor2.isShutdown()) {
                f21724a = new a();
            }
            threadPoolExecutor = f21724a;
        }
        return threadPoolExecutor;
    }
}
