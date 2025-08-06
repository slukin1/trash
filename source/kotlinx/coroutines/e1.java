package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.c;

public final class e1 extends ExecutorCoroutineDispatcher implements p0 {

    /* renamed from: d  reason: collision with root package name */
    public final Executor f57117d;

    public e1(Executor executor) {
        this.f57117d = executor;
        c.a(H());
    }

    public final void G(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        p1.c(coroutineContext, d1.a("The task was rejected", rejectedExecutionException));
    }

    public Executor H() {
        return this.f57117d;
    }

    public final ScheduledFuture<?> I(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j11) {
        try {
            return scheduledExecutorService.schedule(runnable, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            G(coroutineContext, e11);
            return null;
        }
    }

    public void close() {
        Executor H = H();
        ExecutorService executorService = H instanceof ExecutorService ? (ExecutorService) H : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof e1) && ((e1) obj).H() == H();
    }

    public int hashCode() {
        return System.identityHashCode(H());
    }

    public void t(long j11, k<? super Unit> kVar) {
        Executor H = H();
        ScheduledFuture<?> scheduledFuture = null;
        ScheduledExecutorService scheduledExecutorService = H instanceof ScheduledExecutorService ? (ScheduledExecutorService) H : null;
        if (scheduledExecutorService != null) {
            scheduledFuture = I(scheduledExecutorService, new b2(this, kVar), kVar.getContext(), j11);
        }
        if (scheduledFuture != null) {
            p1.g(kVar, scheduledFuture);
        } else {
            l0.f57369i.t(j11, kVar);
        }
    }

    public String toString() {
        return H().toString();
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        Executor H = H();
        ScheduledFuture<?> scheduledFuture = null;
        ScheduledExecutorService scheduledExecutorService = H instanceof ScheduledExecutorService ? (ScheduledExecutorService) H : null;
        if (scheduledExecutorService != null) {
            scheduledFuture = I(scheduledExecutorService, runnable, coroutineContext, j11);
        }
        if (scheduledFuture != null) {
            return new w0(scheduledFuture);
        }
        return l0.f57369i.u(j11, runnable, coroutineContext);
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnable2;
        try {
            Executor H = H();
            AbstractTimeSource a11 = b.a();
            if (a11 == null || (runnable2 = a11.h(runnable)) == null) {
                runnable2 = runnable;
            }
            H.execute(runnable2);
        } catch (RejectedExecutionException e11) {
            AbstractTimeSource a12 = b.a();
            if (a12 != null) {
                a12.e();
            }
            G(coroutineContext, e11);
            v0.b().w(coroutineContext, runnable);
        }
    }
}
