package com.bbc876219.lib.task;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadFactory f63239a;

    /* renamed from: b  reason: collision with root package name */
    public static ThreadPoolExecutor f63240b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f63241c;

    /* renamed from: d  reason: collision with root package name */
    public static final RejectedExecutionHandler f63242d;

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f63243e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f63244f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public static LinkedBlockingQueue<WeakReference<Worker>> f63245g = new LinkedBlockingQueue<>();

    public static abstract class AsyncWorker<Result> {
    }

    public static class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f63246b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Task#" + this.f63246b.getAndIncrement() + runnable.getClass().getName());
        }
    }

    public static class b implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.w("TaskManager", "已经超过线程池列队的最大值了");
            synchronized (this) {
                if (TaskManager.f63240b == null) {
                    LinkedBlockingQueue unused = TaskManager.f63241c = new LinkedBlockingQueue();
                    ThreadPoolExecutor unused2 = TaskManager.f63240b = new ThreadPoolExecutor(5, 5, 3, TimeUnit.SECONDS, TaskManager.f63241c, TaskManager.f63239a);
                    TaskManager.f63240b.allowCoreThreadTimeOut(true);
                }
            }
            TaskManager.f63240b.execute(runnable);
        }
    }

    static {
        a aVar = new a();
        f63239a = aVar;
        b bVar = new b();
        f63242d = bVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(100), aVar);
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        threadPoolExecutor.setRejectedExecutionHandler(bVar);
        f63243e = threadPoolExecutor;
    }

    public static void f(Worker worker) {
        f63243e.execute(worker);
    }

    public static void g(Worker worker) {
        f63244f.postDelayed(worker, 0);
    }
}
