package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zao implements zam {
    private zao() {
    }

    public /* synthetic */ zao(zan zan) {
    }

    public final ExecutorService zaa(ThreadFactory threadFactory, int i11) {
        return zac(1, threadFactory, 1);
    }

    public final ExecutorService zab(int i11, int i12) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zac(int i11, ThreadFactory threadFactory, int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
