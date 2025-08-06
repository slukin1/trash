package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f63466a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Integer, Map<Integer, ExecutorService>> f63467b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Task, ExecutorService> f63468c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final int f63469d = Runtime.getRuntime().availableProcessors();

    /* renamed from: e  reason: collision with root package name */
    public static final Timer f63470e = new Timer();

    /* renamed from: f  reason: collision with root package name */
    public static Executor f63471f;

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity = Integer.MAX_VALUE;
        /* access modifiers changed from: private */
        public volatile b mPool;

        public LinkedBlockingQueue4Util() {
        }

        public boolean offer(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'runnable' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public LinkedBlockingQueue4Util(boolean z11) {
            if (z11) {
                this.mCapacity = 0;
            }
        }

        public LinkedBlockingQueue4Util(int i11) {
            this.mCapacity = i11;
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        public void g(Throwable th2) {
            Log.e("ThreadUtils", "onFail: ", th2);
        }
    }

    public static class SyncValue<T> {

        /* renamed from: a  reason: collision with root package name */
        public CountDownLatch f63472a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        public AtomicBoolean f63473b = new AtomicBoolean();
    }

    public static abstract class Task<T> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f63474b = new AtomicInteger(0);

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f63475c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Thread f63476d;

        /* renamed from: e  reason: collision with root package name */
        public Timer f63477e;

        /* renamed from: f  reason: collision with root package name */
        public long f63478f;

        /* renamed from: g  reason: collision with root package name */
        public e f63479g;

        /* renamed from: h  reason: collision with root package name */
        public Executor f63480h;

        public class a extends TimerTask {
            public a() {
            }

            public void run() {
                if (!Task.this.e() && Task.this.f63479g != null) {
                    Task.this.i();
                    Task.this.f63479g.onTimeout();
                    Task.this.f();
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f63482b;

            public b(Object obj) {
                this.f63482b = obj;
            }

            public void run() {
                Task.this.h(this.f63482b);
            }
        }

        public class c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f63484b;

            public c(Object obj) {
                this.f63484b = obj;
            }

            public void run() {
                Task.this.h(this.f63484b);
                Task.this.f();
            }
        }

        public class d implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Throwable f63486b;

            public d(Throwable th2) {
                this.f63486b = th2;
            }

            public void run() {
                Task.this.g(this.f63486b);
                Task.this.f();
            }
        }

        public interface e {
            void onTimeout();
        }

        public abstract T c() throws Throwable;

        public final Executor d() {
            Executor executor = this.f63480h;
            return executor == null ? ThreadUtils.e() : executor;
        }

        public boolean e() {
            return this.f63474b.get() > 1;
        }

        public void f() {
            ThreadUtils.f63468c.remove(this);
            Timer timer = this.f63477e;
            if (timer != null) {
                timer.cancel();
                this.f63477e = null;
                this.f63479g = null;
            }
        }

        public abstract void g(Throwable th2);

        public abstract void h(T t11);

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.f63476d == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.f63476d.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void i() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.f63474b
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.f63474b     // Catch:{ all -> 0x001f }
                int r1 = r1.get()     // Catch:{ all -> 0x001f }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.f63474b     // Catch:{ all -> 0x001f }
                r2 = 6
                r1.set(r2)     // Catch:{ all -> 0x001f }
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                java.lang.Thread r0 = r3.f63476d
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.f63476d
                r0.interrupt()
            L_0x001e:
                return
            L_0x001f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.Task.i():void");
        }

        public void run() {
            if (this.f63475c) {
                if (this.f63476d == null) {
                    if (this.f63474b.compareAndSet(0, 1)) {
                        this.f63476d = Thread.currentThread();
                        if (this.f63479g != null) {
                            Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                        }
                    } else {
                        return;
                    }
                } else if (this.f63474b.get() != 1) {
                    return;
                }
            } else if (this.f63474b.compareAndSet(0, 1)) {
                this.f63476d = Thread.currentThread();
                if (this.f63479g != null) {
                    Timer timer = new Timer();
                    this.f63477e = timer;
                    timer.schedule(new a(), this.f63478f);
                }
            } else {
                return;
            }
            try {
                Object c11 = c();
                if (this.f63475c) {
                    if (this.f63474b.get() == 1) {
                        d().execute(new b(c11));
                    }
                } else if (this.f63474b.compareAndSet(1, 3)) {
                    d().execute(new c(c11));
                }
            } catch (InterruptedException unused) {
                this.f63474b.compareAndSet(4, 5);
            } catch (Throwable th2) {
                if (this.f63474b.compareAndSet(1, 2)) {
                    d().execute(new d(th2));
                }
            }
        }
    }

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                try {
                    super.run();
                } catch (Throwable th2) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th2);
                }
            }
        }

        public class b implements Thread.UncaughtExceptionHandler {
            public b() {
            }

            public void uncaughtException(Thread thread, Throwable th2) {
                System.out.println(th2);
            }
        }

        public UtilsThreadFactory(String str, int i11) {
            this(str, i11, false);
        }

        public Thread newThread(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'r' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            a aVar = new a(runnable, this.namePrefix + getAndIncrement());
            aVar.setDaemon(this.isDaemon);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.priority);
            return aVar;
        }

        public UtilsThreadFactory(String str, int i11, boolean z11) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i11;
            this.isDaemon = z11;
        }
    }

    public static class a implements Executor {
        public void execute(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            ThreadUtils.h(runnable);
        }
    }

    public static final class b extends ThreadPoolExecutor {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f63490b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        public LinkedBlockingQueue4Util f63491c;

        public b(int i11, int i12, long j11, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i11, i12, j11, timeUnit, linkedBlockingQueue4Util, threadFactory);
            b unused = linkedBlockingQueue4Util.mPool = this;
            this.f63491c = linkedBlockingQueue4Util;
        }

        public static ExecutorService b(int i11, int i12) {
            int i13 = i11;
            int i14 = i12;
            if (i13 == -8) {
                return new b(ThreadUtils.f63469d + 1, (ThreadUtils.f63469d * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i14));
            } else if (i13 == -4) {
                return new b((ThreadUtils.f63469d * 2) + 1, (ThreadUtils.f63469d * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i14));
            } else {
                if (i13 == -2) {
                    return new b(0, 128, 60, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i14));
                } else if (i13 == -1) {
                    return new b(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i14));
                } else {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    LinkedBlockingQueue4Util linkedBlockingQueue4Util = new LinkedBlockingQueue4Util();
                    return new b(i11, i11, 0, timeUnit, linkedBlockingQueue4Util, new UtilsThreadFactory("fixed(" + i13 + ")", i14));
                }
            }
        }

        public void afterExecute(Runnable runnable, Throwable th2) {
            this.f63490b.decrementAndGet();
            super.afterExecute(runnable, th2);
        }

        public void execute(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            if (!isShutdown()) {
                this.f63490b.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.f63491c.offer(runnable);
                } catch (Throwable unused2) {
                    this.f63490b.decrementAndGet();
                }
            }
        }
    }

    public static ExecutorService d() {
        return f(-2);
    }

    public static Executor e() {
        if (f63471f == null) {
            f63471f = new a();
        }
        return f63471f;
    }

    public static ExecutorService f(int i11) {
        return g(i11, 5);
    }

    public static ExecutorService g(int i11, int i12) {
        ExecutorService executorService;
        Map<Integer, Map<Integer, ExecutorService>> map = f63467b;
        synchronized (map) {
            Map map2 = map.get(Integer.valueOf(i11));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = b.b(i11, i12);
                concurrentHashMap.put(Integer.valueOf(i12), executorService);
                map.put(Integer.valueOf(i11), concurrentHashMap);
            } else {
                executorService = (ExecutorService) map2.get(Integer.valueOf(i12));
                if (executorService == null) {
                    executorService = b.b(i11, i12);
                    map2.put(Integer.valueOf(i12), executorService);
                }
            }
        }
        return executorService;
    }

    public static void h(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f63466a.post(runnable);
        }
    }

    public static void i(Runnable runnable, long j11) {
        f63466a.postDelayed(runnable, j11);
    }
}
