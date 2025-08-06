package io.reactivex.rxjava3.internal.schedulers;

import j00.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f55676a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f55677b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f55678c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f55679d = new ConcurrentHashMap();

    public static final class a implements Runnable {
        public void run() {
            Iterator it2 = new ArrayList(d.f55679d.keySet()).iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    d.f55679d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    public static final class b implements h<String, String> {
        /* renamed from: a */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean b11 = b(true, "rx3.purge-enabled", true, true, bVar);
        f55676a = b11;
        f55677b = c(b11, "rx3.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f55676a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static boolean b(boolean z11, String str, boolean z12, boolean z13, h<String, String> hVar) {
        if (!z11) {
            return z13;
        }
        try {
            String apply = hVar.apply(str);
            if (apply == null) {
                return z12;
            }
            return "true".equals(apply);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            return z12;
        }
    }

    public static int c(boolean z11, String str, int i11, int i12, h<String, String> hVar) {
        if (!z11) {
            return i12;
        }
        try {
            String apply = hVar.apply(str);
            if (apply == null) {
                return i11;
            }
            return Integer.parseInt(apply);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            return i11;
        }
    }

    public static void d() {
        f(f55676a);
    }

    public static void e(boolean z11, ScheduledExecutorService scheduledExecutorService) {
        if (z11 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f55679d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void f(boolean z11) {
        if (z11) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f55678c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (atomicReference.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        a aVar = new a();
                        int i11 = f55677b;
                        newScheduledThreadPool.scheduleAtFixedRate(aVar, (long) i11, (long) i11, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}
