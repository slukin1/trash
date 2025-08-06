package vu;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kv.e;

public class f implements Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicInteger f23419d = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    public static final int f23420e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f23421f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f23422g;

    /* renamed from: h  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f23423h = new LinkedBlockingQueue();

    /* renamed from: i  reason: collision with root package name */
    public static f f23424i;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f23425b;

    /* renamed from: c  reason: collision with root package name */
    public c f23426c = new c();

    public class b implements ThreadFactory {
        public b() {
        }

        public Thread newThread(Runnable runnable) {
            e.e("WP-WorkExecutor", "Create thread");
            Thread thread = new Thread(runnable, "WP-WorkExecutor#" + f.f23419d.getAndIncrement());
            thread.setUncaughtExceptionHandler(f.this.f23426c);
            thread.setPriority(4);
            return thread;
        }
    }

    public static class c implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread thread, Throwable th2) {
            e.h("WP-WorkExecutor", "Thread.name=" + thread.getName() + ", id=" + thread.getId() + ", caught:" + th2);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f23420e = availableProcessors;
        f23421f = Math.max(2, Math.min(availableProcessors - 1, 4));
        f23422g = (availableProcessors * 2) + 1;
    }

    public f() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f23421f, f23422g, 30, TimeUnit.SECONDS, f23423h, new b());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f23425b = threadPoolExecutor;
    }

    public static f c() {
        if (f23424i == null) {
            synchronized (f.class) {
                if (f23424i == null) {
                    f23424i = new f();
                }
            }
        }
        return f23424i;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            this.f23425b.execute(runnable);
        }
    }
}
