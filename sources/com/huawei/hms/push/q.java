package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f38432a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadPoolExecutor f38433b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f38432a) {
            threadPoolExecutor = f38433b;
        }
        return threadPoolExecutor;
    }
}
