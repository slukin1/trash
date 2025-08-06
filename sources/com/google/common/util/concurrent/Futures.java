package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.Partially;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

@GwtCompatible(emulated = true)
public final class Futures extends GwtFuturesCatchingSpecialization {

    public static final class CallbackListener<V> implements Runnable {
        public final FutureCallback<? super V> callback;
        public final Future<V> future;

        public CallbackListener(Future<V> future2, FutureCallback<? super V> futureCallback) {
            this.future = future2;
            this.callback = futureCallback;
        }

        public void run() {
            try {
                this.callback.onSuccess(Futures.getDone(this.future));
            } catch (ExecutionException e11) {
                this.callback.onFailure(e11.getCause());
            } catch (Error | RuntimeException e12) {
                this.callback.onFailure(e12);
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).addValue((Object) this.callback).toString();
        }
    }

    @GwtCompatible
    @CanIgnoreReturnValue
    @Beta
    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture((ImmutableCollection<? extends ListenableFuture<?>>) this.futures, this.allMustSucceed, executor, callable);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture((ImmutableCollection<? extends ListenableFuture<?>>) this.futures, this.allMustSucceed, executor, asyncCallable);
        }

        public ListenableFuture<?> run(final Runnable runnable, Executor executor) {
            return call(new Callable<Void>() {
                public Void call() throws Exception {
                    runnable.run();
                    return null;
                }
            }, executor);
        }

        private FutureCombiner(boolean z11, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.allMustSucceed = z11;
            this.futures = immutableList;
        }
    }

    public static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        private InCompletionOrderState<T> state;

        public void afterDone() {
            this.state = null;
        }

        public boolean cancel(boolean z11) {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (!super.cancel(z11)) {
                return false;
            }
            inCompletionOrderState.recordOutputCancellation(z11);
            return true;
        }

        public String pendingToString() {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (inCompletionOrderState == null) {
                return null;
            }
            return "inputCount=[" + inCompletionOrderState.inputFutures.length + "], remaining=[" + inCompletionOrderState.incompleteOutputCount.get() + "]";
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            this.state = inCompletionOrderState;
        }
    }

    public static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        /* access modifiers changed from: private */
        public final AtomicInteger incompleteOutputCount;
        /* access modifiers changed from: private */
        public final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0 && this.wasCancelled) {
                for (ListenableFuture<? extends T> listenableFuture : this.inputFutures) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.shouldInterrupt);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void recordInputCompletion(ImmutableList<AbstractFuture<T>> immutableList, int i11) {
            ListenableFuture<? extends T>[] listenableFutureArr = this.inputFutures;
            ListenableFuture<? extends T> listenableFuture = listenableFutureArr[i11];
            listenableFutureArr[i11] = null;
            for (int i12 = this.delegateIndex; i12 < immutableList.size(); i12++) {
                if (immutableList.get(i12).setFuture(listenableFuture)) {
                    recordCompletion();
                    this.delegateIndex = i12 + 1;
                    return;
                }
            }
            this.delegateIndex = immutableList.size();
        }

        /* access modifiers changed from: private */
        public void recordOutputCancellation(boolean z11) {
            this.wasCancelled = true;
            if (!z11) {
                this.shouldInterrupt = false;
            }
            recordCompletion();
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = listenableFutureArr;
            this.incompleteOutputCount = new AtomicInteger(listenableFutureArr.length);
        }
    }

    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        private ListenableFuture<V> delegate;

        public NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = listenableFuture;
        }

        public void afterDone() {
            this.delegate = null;
        }

        public String pendingToString() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }

        public void run() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf((E[]) listenableFutureArr), true);
    }

    @Beta
    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, function, executor);
    }

    @Beta
    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, asyncFunction, executor);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Beta
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return FuturesGetChecked.getChecked(future, cls);
    }

    @CanIgnoreReturnValue
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", (Object) future);
        return Uninterruptibles.getUninterruptibly(future);
    }

    @CanIgnoreReturnValue
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e11) {
            wrapAndThrowUnchecked(e11.getCause());
            throw new AssertionError();
        }
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th2) {
        Preconditions.checkNotNull(th2);
        return new ImmediateFuture.ImmediateFailedFuture(th2);
    }

    public static <V> ListenableFuture<V> immediateFuture(V v11) {
        if (v11 == null) {
            return ImmediateFuture.ImmediateSuccessfulFuture.NULL;
        }
        return new ImmediateFuture.ImmediateSuccessfulFuture(v11);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.Beta
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<T>> inCompletionOrder(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r6 = (java.util.Collection) r6
            goto L_0x000b
        L_0x0007:
            com.google.common.collect.ImmutableList r6 = com.google.common.collect.ImmutableList.copyOf(r6)
        L_0x000b:
            int r0 = r6.size()
            com.google.common.util.concurrent.ListenableFuture[] r0 = new com.google.common.util.concurrent.ListenableFuture[r0]
            java.lang.Object[] r6 = r6.toArray(r0)
            com.google.common.util.concurrent.ListenableFuture[] r6 = (com.google.common.util.concurrent.ListenableFuture[]) r6
            com.google.common.util.concurrent.Futures$InCompletionOrderState r0 = new com.google.common.util.concurrent.Futures$InCompletionOrderState
            r1 = 0
            r0.<init>(r6)
            com.google.common.collect.ImmutableList$Builder r2 = com.google.common.collect.ImmutableList.builder()
            r3 = 0
            r4 = r3
        L_0x0023:
            int r5 = r6.length
            if (r4 >= r5) goto L_0x0031
            com.google.common.util.concurrent.Futures$InCompletionOrderFuture r5 = new com.google.common.util.concurrent.Futures$InCompletionOrderFuture
            r5.<init>(r0)
            r2.add((java.lang.Object) r5)
            int r4 = r4 + 1
            goto L_0x0023
        L_0x0031:
            com.google.common.collect.ImmutableList r1 = r2.build()
        L_0x0035:
            int r2 = r6.length
            if (r3 >= r2) goto L_0x0049
            r2 = r6[r3]
            com.google.common.util.concurrent.Futures$3 r4 = new com.google.common.util.concurrent.Futures$3
            r4.<init>(r0, r1, r3)
            java.util.concurrent.Executor r5 = com.google.common.util.concurrent.MoreExecutors.directExecutor()
            r2.addListener(r4, r5)
            int r3 = r3 + 1
            goto L_0x0035
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Futures.inCompletionOrder(java.lang.Iterable):com.google.common.collect.ImmutableList");
    }

    @GwtIncompatible
    @Beta
    public static <I, O> Future<O> lazyTransform(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future<O>() {
            private O applyTransformation(I i11) throws ExecutionException {
                try {
                    return function.apply(i11);
                } catch (Throwable th2) {
                    throw new ExecutionException(th2);
                }
            }

            public boolean cancel(boolean z11) {
                return future.cancel(z11);
            }

            public O get() throws InterruptedException, ExecutionException {
                return applyTransformation(future.get());
            }

            public boolean isCancelled() {
                return future.isCancelled();
            }

            public boolean isDone() {
                return future.isDone();
            }

            public O get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return applyTransformation(future.get(j11, timeUnit));
            }
        };
    }

    @Beta
    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.addListener(nonCancellationPropagatingFuture, MoreExecutors.directExecutor());
        return nonCancellationPropagatingFuture;
    }

    @GwtIncompatible
    @Beta
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask<O> create = TrustedListenableFutureTask.create(asyncCallable);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(create, j11, timeUnit);
        create.addListener(new Runnable() {
            public void run() {
                schedule.cancel(false);
            }
        }, MoreExecutors.directExecutor());
        return create;
    }

    @Beta
    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask<O> create = TrustedListenableFutureTask.create(asyncCallable);
        executor.execute(create);
        return create;
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf((E[]) listenableFutureArr), false);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, asyncFunction, executor);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.copyOf((E[]) listenableFutureArr));
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.copyOf((E[]) listenableFutureArr));
    }

    @GwtIncompatible
    @Beta
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return TimeoutFuture.create(listenableFuture, j11, timeUnit, scheduledExecutorService);
    }

    private static void wrapAndThrowUnchecked(Throwable th2) {
        if (th2 instanceof Error) {
            throw new ExecutionError((Error) th2);
        }
        throw new UncheckedExecutionException(th2);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), true);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Beta
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j11, TimeUnit timeUnit) throws Exception {
        return FuturesGetChecked.getChecked(future, cls, j11, timeUnit);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(iterable));
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(iterable));
    }
}
