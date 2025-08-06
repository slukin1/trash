package com.sumsub.sns.internal.fingerprint.tools.threading;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f34672a = a();

    public static final void a(ThreadPoolExecutor threadPoolExecutor) {
        f34672a = threadPoolExecutor;
    }

    public static final ThreadPoolExecutor b() {
        return f34672a;
    }

    public static final ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
    }
}
