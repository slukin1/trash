package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
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

public abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadFactory f10060g;

    /* renamed from: h  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f10061h;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f10062i;

    /* renamed from: j  reason: collision with root package name */
    public static f f10063j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile Executor f10064k;

    /* renamed from: b  reason: collision with root package name */
    public final g<Params, Result> f10065b;

    /* renamed from: c  reason: collision with root package name */
    public final FutureTask<Result> f10066c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Status f10067d = Status.PENDING;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f10068e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f10069f = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f10070b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f10070b.getAndIncrement());
        }
    }

    public class b extends g<Params, Result> {
        public b() {
        }

        public Result call() throws Exception {
            ModernAsyncTask.this.f10069f.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = ModernAsyncTask.this.b(this.f10076b);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.l(result);
                return result;
            } catch (Throwable th2) {
                ModernAsyncTask.this.l(result);
                throw th2;
            }
        }
    }

    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        public void done() {
            try {
                ModernAsyncTask.this.m(get());
            } catch (InterruptedException e11) {
                Log.w("AsyncTask", e11);
            } catch (ExecutionException e12) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e12.getCause());
            } catch (CancellationException unused) {
                ModernAsyncTask.this.m(null);
            } catch (Throwable th2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th2);
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10073a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10073a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10073a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.d.<clinit>():void");
        }
    }

    public static class e<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final ModernAsyncTask f10074a;

        /* renamed from: b  reason: collision with root package name */
        public final Data[] f10075b;

        public e(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f10074a = modernAsyncTask;
            this.f10075b = dataArr;
        }
    }

    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i11 = message.what;
            if (i11 == 1) {
                eVar.f10074a.d(eVar.f10075b[0]);
            } else if (i11 == 2) {
                eVar.f10074a.k(eVar.f10075b);
            }
        }
    }

    public static abstract class g<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        public Params[] f10076b;
    }

    static {
        a aVar = new a();
        f10060g = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f10061h = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f10062i = threadPoolExecutor;
        f10064k = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        b bVar = new b();
        this.f10065b = bVar;
        this.f10066c = new c(bVar);
    }

    public static Handler e() {
        f fVar;
        synchronized (ModernAsyncTask.class) {
            if (f10063j == null) {
                f10063j = new f();
            }
            fVar = f10063j;
        }
        return fVar;
    }

    public final boolean a(boolean z11) {
        this.f10068e.set(true);
        return this.f10066c.cancel(z11);
    }

    public abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f10067d != Status.PENDING) {
            int i11 = d.f10073a[this.f10067d.ordinal()];
            if (i11 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i11 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f10067d = Status.RUNNING;
            j();
            this.f10065b.f10076b = paramsArr;
            executor.execute(this.f10066c);
            return this;
        }
    }

    public void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f10067d = Status.FINISHED;
    }

    public final boolean f() {
        return this.f10068e.get();
    }

    public void g() {
    }

    public void h(Result result) {
        g();
    }

    public void i(Result result) {
    }

    public void j() {
    }

    public void k(Progress... progressArr) {
    }

    public Result l(Result result) {
        e().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    public void m(Result result) {
        if (!this.f10069f.get()) {
            l(result);
        }
    }
}
