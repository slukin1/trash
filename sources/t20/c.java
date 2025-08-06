package t20;

import java.lang.Thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

public class c extends Statement {

    /* renamed from: a  reason: collision with root package name */
    public final Statement f26183a;

    /* renamed from: b  reason: collision with root package name */
    public final TimeUnit f26184b;

    /* renamed from: c  reason: collision with root package name */
    public final long f26185c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f26186d;

    /* renamed from: e  reason: collision with root package name */
    public volatile ThreadGroup f26187e;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26188a;

        /* renamed from: b  reason: collision with root package name */
        public long f26189b;

        /* renamed from: c  reason: collision with root package name */
        public TimeUnit f26190c;

        public c d(Statement statement) {
            Objects.requireNonNull(statement, "statement cannot be null");
            return new c(this, statement);
        }

        public b e(long j11, TimeUnit timeUnit) {
            if (j11 >= 0) {
                Objects.requireNonNull(timeUnit, "TimeUnit cannot be null");
                this.f26189b = j11;
                this.f26190c = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("timeout must be non-negative");
        }

        public b() {
            this.f26188a = false;
            this.f26189b = 0;
            this.f26190c = TimeUnit.SECONDS;
        }
    }

    /* renamed from: t20.c$c  reason: collision with other inner class name */
    public class C0228c implements Callable<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final CountDownLatch f26191b;

        public C0228c() {
            this.f26191b = new CountDownLatch(1);
        }

        public void a() throws InterruptedException {
            this.f26191b.await();
        }

        /* renamed from: b */
        public Throwable call() throws Exception {
            try {
                this.f26191b.countDown();
                c.this.f26183a.a();
                return null;
            } catch (Exception e11) {
                throw e11;
            } catch (Throwable th2) {
                return th2;
            }
        }
    }

    public static b c() {
        return new b();
    }

    public void a() throws Throwable {
        C0228c cVar = new C0228c();
        FutureTask futureTask = new FutureTask(cVar);
        this.f26187e = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(this.f26187e, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        cVar.a();
        Throwable g11 = g(futureTask, thread);
        if (g11 != null) {
            throw g11;
        }
    }

    public final Thread[] d(Thread[] threadArr, int i11) {
        int min = Math.min(i11, threadArr.length);
        Thread[] threadArr2 = new Thread[min];
        for (int i12 = 0; i12 < min; i12++) {
            threadArr2[i12] = threadArr[i12];
        }
        return threadArr2;
    }

    public final long e(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (!threadMXBean.isThreadCpuTimeSupported()) {
            return 0;
        }
        try {
            return threadMXBean.getThreadCpuTime(thread.getId());
        } catch (UnsupportedOperationException unused) {
            return 0;
        }
    }

    public final Exception f(Thread thread) {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        Thread i11 = this.f26186d ? i(thread) : null;
        TestTimedOutException testTimedOutException = new TestTimedOutException(this.f26185c, this.f26184b);
        if (stackTrace != null) {
            testTimedOutException.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (i11 == null) {
            return testTimedOutException;
        }
        Exception exc = new Exception("Appears to be stuck in thread " + i11.getName());
        exc.setStackTrace(h(i11));
        return new MultipleFailureException(Arrays.asList(new Throwable[]{testTimedOutException, exc}));
    }

    public final Throwable g(FutureTask<Throwable> futureTask, Thread thread) {
        try {
            long j11 = this.f26185c;
            if (j11 > 0) {
                return futureTask.get(j11, this.f26184b);
            }
            return futureTask.get();
        } catch (InterruptedException e11) {
            return e11;
        } catch (ExecutionException e12) {
            return e12.getCause();
        } catch (TimeoutException unused) {
            return f(thread);
        }
    }

    public final StackTraceElement[] h(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException unused) {
            return new StackTraceElement[0];
        }
    }

    public final Thread i(Thread thread) {
        Thread[] j11;
        if (this.f26187e == null || (j11 = j(this.f26187e)) == null) {
            return null;
        }
        long j12 = 0;
        Thread thread2 = null;
        for (Thread thread3 : j11) {
            if (thread3.getState() == Thread.State.RUNNABLE) {
                long e11 = e(thread3);
                if (thread2 == null || e11 > j12) {
                    thread2 = thread3;
                    j12 = e11;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    public final Thread[] j(ThreadGroup threadGroup) {
        int max = Math.max(threadGroup.activeCount() * 2, 100);
        int i11 = 0;
        do {
            Thread[] threadArr = new Thread[max];
            int enumerate = threadGroup.enumerate(threadArr);
            if (enumerate < max) {
                return d(threadArr, enumerate);
            }
            max += 100;
            i11++;
        } while (i11 < 5);
        return null;
    }

    @Deprecated
    public c(Statement statement, long j11) {
        this(c().e(j11, TimeUnit.MILLISECONDS), statement);
    }

    public c(b bVar, Statement statement) {
        this.f26187e = null;
        this.f26183a = statement;
        this.f26185c = bVar.f26189b;
        this.f26184b = bVar.f26190c;
        this.f26186d = bVar.f26188a;
    }
}
