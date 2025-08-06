package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.Executor;

@GwtCompatible
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    public Class<X> exceptionType;
    public F fallback;
    public ListenableFuture<? extends V> inputFuture;

    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x11) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x11);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) asyncFunction);
            return apply;
        }

        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        public CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        public void setResult(V v11) {
            set(v11);
        }

        public V doFallback(Function<? super X, ? extends V> function, X x11) throws Exception {
            return function.apply(x11);
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f11) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = Preconditions.checkNotNull(f11);
    }

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @ForOverride
    public abstract T doFallback(F f11, X x11) throws Exception;

    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f11 != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + f11 + "]";
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r7.inputFuture
            java.lang.Class<X> r1 = r7.exceptionType
            F r2 = r7.fallback
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = r3
            goto L_0x0012
        L_0x0011:
            r6 = r4
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r3 = r3 | r5
            boolean r4 = r7.isCancelled()
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0020
            return
        L_0x0020:
            r3 = 0
            r7.inputFuture = r3
            java.lang.Object r4 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch:{ ExecutionException -> 0x002c, all -> 0x002a }
            r5 = r4
            r4 = r3
            goto L_0x0038
        L_0x002a:
            r4 = move-exception
            goto L_0x0037
        L_0x002c:
            r4 = move-exception
            java.lang.Throwable r4 = r4.getCause()
            java.lang.Object r4 = com.google.common.base.Preconditions.checkNotNull(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r4 != 0) goto L_0x003e
            r7.set(r5)
            return
        L_0x003e:
            boolean r1 = com.google.common.util.concurrent.Platform.isInstanceOfThrowableClass(r4, r1)
            if (r1 != 0) goto L_0x0048
            r7.setFuture(r0)
            return
        L_0x0048:
            java.lang.Object r0 = r7.doFallback(r2, r4)     // Catch:{ all -> 0x0054 }
            r7.exceptionType = r3
            r7.fallback = r3
            r7.setResult(r0)
            return
        L_0x0054:
            r0 = move-exception
            r7.setException(r0)     // Catch:{ all -> 0x005d }
            r7.exceptionType = r3
            r7.fallback = r3
            return
        L_0x005d:
            r0 = move-exception
            r7.exceptionType = r3
            r7.fallback = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    @ForOverride
    public abstract void setResult(T t11);

    public static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }
}
