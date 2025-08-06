package com.mob.tools.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mob.tools.MobLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ExecutorDispatcher implements a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile ExecutorDispatcher f28044b;

    /* renamed from: a  reason: collision with root package name */
    private final a f28045a = new a();

    public static abstract class SafeRunnable implements Runnable {
        public void afterRun() {
        }

        public void beforeRun() {
        }

        public void handleException(Throwable th2) {
        }

        public String name() {
            return "";
        }

        public void run() {
            try {
                String name = name();
                if (!TextUtils.isEmpty(name)) {
                    Thread.currentThread().setName(name);
                }
                beforeRun();
                safeRun();
                afterRun();
            } catch (Throwable unused) {
            }
        }

        public abstract void safeRun();
    }

    public static final class a implements a {

        /* renamed from: a  reason: collision with root package name */
        private final ExecutorService f28046a;

        /* renamed from: b  reason: collision with root package name */
        private final ExecutorService f28047b;

        /* renamed from: c  reason: collision with root package name */
        private final ExecutorService f28048c;

        /* renamed from: d  reason: collision with root package name */
        private final Handler f28049d;

        public <T extends SafeRunnable> void executeDelayed(final T t11, long j11) {
            if (t11 != null) {
                try {
                    this.f28049d.postDelayed(new SafeRunnable() {
                        public void safeRun() {
                            a.this.executeImmediately(t11);
                        }
                    }, j11);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
        }

        public <T extends SafeRunnable> void executeDuctile(T t11) {
            try {
                this.f28047b.execute(t11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }

        public <T extends SafeRunnable> void executeImmediately(T t11) {
            try {
                this.f28046a.execute(t11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }

        public <T extends SafeRunnable> void executeSerial(T t11) {
            try {
                this.f28048c.execute(t11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }

        private a() {
            this.f28049d = new Handler(Looper.getMainLooper());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, timeUnit, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.f28046a = threadPoolExecutor;
            this.f28047b = new ThreadPoolExecutor(2, 2, 10, timeUnit, new LinkedBlockingQueue());
            this.f28048c = Executors.newSingleThreadExecutor();
        }
    }

    public static a getInstance() {
        if (f28044b == null) {
            synchronized (ExecutorDispatcher.class) {
                if (f28044b == null) {
                    f28044b = new ExecutorDispatcher();
                }
            }
        }
        return f28044b;
    }

    public <T extends SafeRunnable> void executeDelayed(T t11, long j11) {
        if (t11 != null) {
            if (j11 <= 0) {
                try {
                    this.f28045a.executeDuctile(t11);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            } else {
                this.f28045a.executeDelayed(t11, j11);
            }
        }
    }

    public <T extends SafeRunnable> void executeDuctile(T t11) {
        if (t11 != null) {
            try {
                this.f28045a.executeDuctile(t11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public <T extends SafeRunnable> void executeImmediately(T t11) {
        if (t11 != null) {
            try {
                this.f28045a.executeImmediately(t11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public <T extends SafeRunnable> void executeSerial(T t11) {
        if (t11 != null) {
            try {
                this.f28045a.executeSerial(t11);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }
}
