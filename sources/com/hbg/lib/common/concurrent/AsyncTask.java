package com.hbg.lib.common.concurrent;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {

    /* renamed from: f  reason: collision with root package name */
    public static final int f67416f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadFactory f67417g;

    /* renamed from: h  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f67418h;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f67419i;

    /* renamed from: j  reason: collision with root package name */
    public static final Executor f67420j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile Executor f67421k;

    /* renamed from: l  reason: collision with root package name */
    public static InternalHandler f67422l;

    /* renamed from: a  reason: collision with root package name */
    public final f<Params, Result> f67423a;

    /* renamed from: b  reason: collision with root package name */
    public final FutureTask<Result> f67424b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Status f67425c = Status.PENDING;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f67426d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f67427e = new AtomicBoolean();

    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i11 = message.what;
            if (i11 == 1) {
                dVar.f67431a.f(dVar.f67432b[0]);
            } else if (i11 == 2) {
                dVar.f67431a.l(dVar.f67432b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f67428b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f67428b.getAndIncrement());
        }
    }

    public class b extends f<Params, Result> {
        public b() {
            super((a) null);
        }

        public Result call() throws Exception {
            AsyncTask.this.f67427e.set(true);
            Process.setThreadPriority(10);
            Object e11 = AsyncTask.this.e(this.f67437b);
            Binder.flushPendingCommands();
            return AsyncTask.this.m(e11);
        }
    }

    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        public void done() {
            try {
                AsyncTask.this.n(get());
            } catch (InterruptedException e11) {
                Log.w("AsyncTask", e11);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e12) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e12.getCause());
            } catch (CancellationException unused) {
                AsyncTask.this.n(null);
            }
        }
    }

    public static class d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final AsyncTask f67431a;

        /* renamed from: b  reason: collision with root package name */
        public final Data[] f67432b;

        public d(AsyncTask asyncTask, Data... dataArr) {
            this.f67431a = asyncTask;
            this.f67432b = dataArr;
        }
    }

    public static abstract class f<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        public Params[] f67437b;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        a aVar = new a();
        f67417g = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f67418h = linkedBlockingQueue;
        f67419i = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        e eVar = new e((a) null);
        f67420j = eVar;
        f67421k = eVar;
    }

    public AsyncTask() {
        b bVar = new b();
        this.f67423a = bVar;
        this.f67424b = new c(bVar);
    }

    public static Handler g() {
        InternalHandler internalHandler;
        synchronized (AsyncTask.class) {
            if (f67422l == null) {
                f67422l = new InternalHandler();
            }
            internalHandler = f67422l;
        }
        return internalHandler;
    }

    public abstract Result e(Params... paramsArr);

    public final void f(Result result) {
        if (h()) {
            j(result);
        } else {
            k(result);
        }
        this.f67425c = Status.FINISHED;
    }

    public final boolean h() {
        return this.f67426d.get();
    }

    public void i() {
    }

    public void j(Result result) {
        i();
    }

    public void k(Result result) {
    }

    public void l(Progress... progressArr) {
    }

    public final Result m(Result result) {
        g().obtainMessage(1, new d(this, result)).sendToTarget();
        return result;
    }

    public final void n(Result result) {
        if (!this.f67427e.get()) {
            m(result);
        }
    }

    public static class e implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final ArrayDeque<Runnable> f67433b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f67434c;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Runnable f67435b;

            public a(Runnable runnable) {
                this.f67435b = runnable;
            }

            public void run() {
                try {
                    this.f67435b.run();
                } finally {
                    e.this.a();
                }
            }
        }

        public e() {
            this.f67433b = new ArrayDeque<>();
        }

        public synchronized void a() {
            Runnable poll = this.f67433b.poll();
            this.f67434c = poll;
            if (poll != null) {
                AsyncTask.f67419i.execute(poll);
            }
        }

        public synchronized void execute(Runnable runnable) {
            this.f67433b.offer(new a(runnable));
            if (this.f67434c == null) {
                a();
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }
}
