package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {

    /* renamed from: i  reason: collision with root package name */
    public volatile InterruptibleTask<?> f11364i;

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable2) {
            this.callable = (Callable) Preconditions.i(callable2);
        }

        public void afterRanInterruptibly(V v11, Throwable th2) {
            if (th2 == null) {
                TrustedListenableFutureTask.this.y(v11);
            } else {
                TrustedListenableFutureTask.this.z(th2);
            }
        }

        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.f11364i = new TrustedFutureInterruptibleTask(callable);
    }

    public static <V> TrustedListenableFutureTask<V> C(Runnable runnable, V v11) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v11));
    }

    public static <V> TrustedListenableFutureTask<V> D(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    public void m() {
        InterruptibleTask<?> interruptibleTask;
        super.m();
        if (B() && (interruptibleTask = this.f11364i) != null) {
            interruptibleTask.interruptTask();
        }
        this.f11364i = null;
    }

    public void run() {
        InterruptibleTask<?> interruptibleTask = this.f11364i;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.f11364i = null;
    }

    public String v() {
        InterruptibleTask<?> interruptibleTask = this.f11364i;
        if (interruptibleTask == null) {
            return super.v();
        }
        String valueOf = String.valueOf(interruptibleTask);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
        sb2.append("task=[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }
}
