package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public abstract class AbstractListeningExecutorService extends AbstractExecutorService {
    /* renamed from: a */
    public ListenableFuture<?> submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    /* renamed from: b */
    public <T> ListenableFuture<T> submit(Runnable runnable, T t11) {
        return (ListenableFuture) super.submit(runnable, t11);
    }

    /* renamed from: c */
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return (ListenableFuture) super.submit(callable);
    }

    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t11) {
        return TrustedListenableFutureTask.C(runnable, t11);
    }

    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.D(callable);
    }
}
