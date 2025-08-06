package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = new Function<Object, Object>() {
        public Object apply(Object obj) {
            return obj;
        }
    };

    public static final class CallbackListener<V> implements Runnable {
        public final FutureCallback<? super V> mCallback;
        public final Future<V> mFuture;

        public CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.mFuture = future;
            this.mCallback = futureCallback;
        }

        public void run() {
            try {
                this.mCallback.onSuccess(Futures.getDone(this.mFuture));
            } catch (ExecutionException e11) {
                Throwable cause = e11.getCause();
                if (cause == null) {
                    this.mCallback.onFailure(e11);
                } else {
                    this.mCallback.onFailure(cause);
                }
            } catch (Error | RuntimeException e12) {
                this.mCallback.onFailure(e12);
            }
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mCallback;
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        h.g(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static <V> ListenableFuture<List<V>> allAsList(Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), true, CameraXExecutors.directExecutor());
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        boolean isDone = future.isDone();
        h.j(isDone, "Future was expected to be done, " + future);
        return getUninterruptibly(future);
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v11;
        boolean z11 = false;
        while (true) {
            try {
                v11 = future.get();
                break;
            } catch (InterruptedException unused) {
                z11 = true;
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return v11;
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th2) {
        return new ImmediateFuture.ImmediateFailedFuture(th2);
    }

    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(Throwable th2) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(th2);
    }

    public static <V> ListenableFuture<V> immediateFuture(V v11) {
        if (v11 == null) {
            return ImmediateFuture.nullFuture();
        }
        return new ImmediateFuture.ImmediateSuccessfulFuture(v11);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        h.g(listenableFuture);
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return CallbackToFutureAdapter.a(new a(listenableFuture));
    }

    public static <V> void propagate(ListenableFuture<V> listenableFuture, CallbackToFutureAdapter.a<V> aVar) {
        propagateTransform(listenableFuture, IDENTITY_FUNCTION, aVar, CameraXExecutors.directExecutor());
    }

    public static <I, O> void propagateTransform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, CallbackToFutureAdapter.a<O> aVar, Executor executor) {
        propagateTransform(true, listenableFuture, function, aVar, executor);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), false, CameraXExecutors.directExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, final Function<? super I, ? extends O> function, Executor executor) {
        h.g(function);
        return transformAsync(listenableFuture, new AsyncFunction<I, O>() {
            public ListenableFuture<O> apply(I i11) {
                return Futures.immediateFuture(Function.this.apply(i11));
            }
        }, executor);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }

    /* access modifiers changed from: private */
    public static <I, O> void propagateTransform(boolean z11, final ListenableFuture<I> listenableFuture, final Function<? super I, ? extends O> function, final CallbackToFutureAdapter.a<O> aVar, Executor executor) {
        h.g(listenableFuture);
        h.g(function);
        h.g(aVar);
        h.g(executor);
        addCallback(listenableFuture, new FutureCallback<I>() {
            public void onFailure(Throwable th2) {
                CallbackToFutureAdapter.a.this.f(th2);
            }

            public void onSuccess(I i11) {
                try {
                    CallbackToFutureAdapter.a.this.c(function.apply(i11));
                } catch (Throwable th2) {
                    CallbackToFutureAdapter.a.this.f(th2);
                }
            }
        }, executor);
        if (z11) {
            aVar.a(new Runnable() {
                public void run() {
                    ListenableFuture.this.cancel(true);
                }
            }, CameraXExecutors.directExecutor());
        }
    }
}
