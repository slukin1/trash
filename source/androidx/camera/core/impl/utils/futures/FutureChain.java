package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureChain<V> implements ListenableFuture<V> {
    public CallbackToFutureAdapter.a<V> mCompleter;
    private final ListenableFuture<V> mDelegate;

    public FutureChain(ListenableFuture<V> listenableFuture) {
        this.mDelegate = (ListenableFuture) h.g(listenableFuture);
    }

    public static <V> FutureChain<V> from(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof FutureChain ? (FutureChain) listenableFuture : new FutureChain<>(listenableFuture);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean z11) {
        return this.mDelegate.cancel(z11);
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.mDelegate.get();
    }

    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    /* access modifiers changed from: package-private */
    public boolean set(V v11) {
        CallbackToFutureAdapter.a<V> aVar = this.mCompleter;
        if (aVar != null) {
            return aVar.c(v11);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean setException(Throwable th2) {
        CallbackToFutureAdapter.a<V> aVar = this.mCompleter;
        if (aVar != null) {
            return aVar.f(th2);
        }
        return false;
    }

    public final <T> FutureChain<T> transform(Function<? super V, T> function, Executor executor) {
        return (FutureChain) Futures.transform(this, function, executor);
    }

    public final <T> FutureChain<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FutureChain) Futures.transformAsync(this, asyncFunction, executor);
    }

    public V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mDelegate.get(j11, timeUnit);
    }

    public FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b<V>() {
            public Object attachCompleter(CallbackToFutureAdapter.a<V> aVar) {
                h.j(FutureChain.this.mCompleter == null, "The result can only set once!");
                FutureChain.this.mCompleter = aVar;
                return "FutureChain[" + FutureChain.this + "]";
            }
        });
    }
}
