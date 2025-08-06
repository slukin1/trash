package w2;

import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f16746a;

    public static class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f16747b;

        public a(String str) {
            this.f16747b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f16747b + c.b());
            thread.setPriority(4);
            thread.setUncaughtExceptionHandler(new com.alibaba.sdk.android.httpdns.d.a());
            return thread;
        }
    }

    public static class b implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "httpdns" + c.b());
            thread.setPriority(4);
            thread.setUncaughtExceptionHandler(new com.alibaba.sdk.android.httpdns.d.a());
            return thread;
        }
    }

    /* renamed from: w2.c$c  reason: collision with other inner class name */
    public static class C0109c implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "httpdns_db" + c.b());
            thread.setPriority(4);
            thread.setUncaughtExceptionHandler(new com.alibaba.sdk.android.httpdns.d.a());
            return thread;
        }
    }

    public static class d implements ExecutorService {

        /* renamed from: b  reason: collision with root package name */
        public final ThreadPoolExecutor f16748b;

        public d(ThreadPoolExecutor threadPoolExecutor) {
            this.f16748b = threadPoolExecutor;
        }

        public boolean awaitTermination(long j11, TimeUnit timeUnit) {
            return this.f16748b.awaitTermination(j11, timeUnit);
        }

        public void execute(Runnable runnable) {
            try {
                this.f16748b.execute(runnable);
            } catch (Exception e11) {
                if (HttpDnsLog.f()) {
                    HttpDnsLog.d("too many request ?", e11);
                }
                throw e11;
            }
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            try {
                return this.f16748b.invokeAll(collection);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) {
            try {
                return this.f16748b.invokeAll(collection, j11, timeUnit);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            try {
                return this.f16748b.invokeAny(collection);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) {
            try {
                return this.f16748b.invokeAny(collection, j11, timeUnit);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }

        public boolean isShutdown() {
            return this.f16748b.isShutdown();
        }

        public boolean isTerminated() {
            return this.f16748b.isTerminated();
        }

        public void shutdown() {
            this.f16748b.shutdown();
        }

        public List<Runnable> shutdownNow() {
            return this.f16748b.shutdownNow();
        }

        public Future<?> submit(Runnable runnable) {
            try {
                return this.f16748b.submit(runnable);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }

        public <T> Future<T> submit(Runnable runnable, T t11) {
            try {
                return this.f16748b.submit(runnable, t11);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }

        public <T> Future<T> submit(Callable<T> callable) {
            try {
                return this.f16748b.submit(callable);
            } catch (RejectedExecutionException e11) {
                HttpDnsLog.d("too many request ?", e11);
                throw e11;
            }
        }
    }

    public static ExecutorService a(String str) {
        return new d(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(4), new a(str), new ThreadPoolExecutor.AbortPolicy()));
    }

    public static /* synthetic */ int b() {
        int i11 = f16746a;
        f16746a = i11 + 1;
        return i11;
    }

    public static ExecutorService c() {
        return new d(new ThreadPoolExecutor(0, 10, 30, TimeUnit.SECONDS, new SynchronousQueue(), new b(), new ThreadPoolExecutor.AbortPolicy()));
    }

    public static ExecutorService d() {
        return new d(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(4), new C0109c(), new ThreadPoolExecutor.AbortPolicy()));
    }
}
