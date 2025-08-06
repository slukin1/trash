package r3;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class a implements ExecutorService {

    /* renamed from: c  reason: collision with root package name */
    public static final long f66578c = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: d  reason: collision with root package name */
    public static volatile int f66579d;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f66580b;

    /* renamed from: r3.a$a  reason: collision with other inner class name */
    public static final class C0725a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f66581a;

        /* renamed from: b  reason: collision with root package name */
        public int f66582b;

        /* renamed from: c  reason: collision with root package name */
        public int f66583c;

        /* renamed from: d  reason: collision with root package name */
        public c f66584d = c.f66595d;

        /* renamed from: e  reason: collision with root package name */
        public String f66585e;

        /* renamed from: f  reason: collision with root package name */
        public long f66586f;

        public C0725a(boolean z11) {
            this.f66581a = z11;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f66585e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f66582b, this.f66583c, this.f66586f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f66585e, this.f66584d, this.f66581a));
                if (this.f66586f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f66585e);
        }

        public C0725a b(String str) {
            this.f66585e = str;
            return this;
        }

        public C0725a c(int i11) {
            this.f66582b = i11;
            this.f66583c = i11;
            return this;
        }
    }

    public static final class b implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final String f66587b;

        /* renamed from: c  reason: collision with root package name */
        public final c f66588c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f66589d;

        /* renamed from: e  reason: collision with root package name */
        public int f66590e;

        /* renamed from: r3.a$b$a  reason: collision with other inner class name */
        public class C0726a extends Thread {
            public C0726a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f66589d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th2) {
                    b.this.f66588c.a(th2);
                }
            }
        }

        public b(String str, c cVar, boolean z11) {
            this.f66587b = str;
            this.f66588c = cVar;
            this.f66589d = z11;
        }

        public synchronized Thread newThread(Runnable runnable) {
            C0726a aVar;
            aVar = new C0726a(runnable, "glide-" + this.f66587b + "-thread-" + this.f66590e);
            this.f66590e = this.f66590e + 1;
            return aVar;
        }
    }

    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f66592a = new C0727a();

        /* renamed from: b  reason: collision with root package name */
        public static final c f66593b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f66594c = new C0728c();

        /* renamed from: d  reason: collision with root package name */
        public static final c f66595d;

        /* renamed from: r3.a$c$a  reason: collision with other inner class name */
        public class C0727a implements c {
            public void a(Throwable th2) {
            }
        }

        public class b implements c {
            public void a(Throwable th2) {
                if (th2 != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th2);
                }
            }
        }

        /* renamed from: r3.a$c$c  reason: collision with other inner class name */
        public class C0728c implements c {
            public void a(Throwable th2) {
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        }

        static {
            b bVar = new b();
            f66593b = bVar;
            f66595d = bVar;
        }

        void a(Throwable th2);
    }

    public a(ExecutorService executorService) {
        this.f66580b = executorService;
    }

    public static int a() {
        if (f66579d == 0) {
            f66579d = Math.min(4, b.a());
        }
        return f66579d;
    }

    public static C0725a b() {
        return new C0725a(true).c(a() >= 4 ? 2 : 1).b("animation");
    }

    public static a c() {
        return b().a();
    }

    public static C0725a d() {
        return new C0725a(true).c(1).b("disk-cache");
    }

    public static a e() {
        return d().a();
    }

    public static C0725a f() {
        return new C0725a(false).c(a()).b("source");
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f66578c, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f66595d, false)));
    }

    public boolean awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.f66580b.awaitTermination(j11, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f66580b.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f66580b.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f66580b.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f66580b.isShutdown();
    }

    public boolean isTerminated() {
        return this.f66580b.isTerminated();
    }

    public void shutdown() {
        this.f66580b.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f66580b.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f66580b.submit(runnable);
    }

    public String toString() {
        return this.f66580b.toString();
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.f66580b.invokeAll(collection, j11, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f66580b.invokeAny(collection, j11, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t11) {
        return this.f66580b.submit(runnable, t11);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f66580b.submit(callable);
    }
}
