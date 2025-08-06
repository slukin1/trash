package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements b {
    private static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public volatile boolean cancelled;
    public final h<? super Object[], ? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public Object[] latest;
    public final ObservableCombineLatest$CombinerObserver<T, R>[] observers;
    public final a<Object[]> queue;

    public ObservableCombineLatest$LatestCoordinator(k<? super R> kVar, h<? super Object[], ? extends R> hVar, int i11, int i12, boolean z11) {
        this.downstream = kVar;
        this.combiner = hVar;
        this.delayError = z11;
        this.latest = new Object[i11];
        ObservableCombineLatest$CombinerObserver<T, R>[] observableCombineLatest$CombinerObserverArr = new ObservableCombineLatest$CombinerObserver[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            observableCombineLatest$CombinerObserverArr[i13] = new ObservableCombineLatest$CombinerObserver<>(this, i13);
        }
        this.observers = observableCombineLatest$CombinerObserverArr;
        this.queue = new a<>(i12);
    }

    public void cancelSources() {
        for (ObservableCombineLatest$CombinerObserver<T, R> dispose : this.observers) {
            dispose.dispose();
        }
    }

    public void clear(a<?> aVar) {
        synchronized (this) {
            this.latest = null;
        }
        aVar.clear();
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelSources();
            drain();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            a<Object[]> aVar = this.queue;
            k<? super R> kVar = this.downstream;
            boolean z11 = this.delayError;
            int i11 = 1;
            while (!this.cancelled) {
                if (z11 || this.errors.get() == null) {
                    boolean z12 = this.done;
                    Object[] poll = aVar.poll();
                    boolean z13 = poll == null;
                    if (z12 && z13) {
                        clear(aVar);
                        this.errors.tryTerminateConsumer((k<?>) kVar);
                        return;
                    } else if (z13) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        try {
                            Object apply = this.combiner.apply(poll);
                            Objects.requireNonNull(apply, "The combiner returned a null value");
                            kVar.onNext(apply);
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            this.errors.tryAddThrowableOrReport(th2);
                            cancelSources();
                            clear(aVar);
                            this.errors.tryTerminateConsumer((k<?>) kVar);
                            return;
                        }
                    }
                } else {
                    cancelSources();
                    clear(aVar);
                    this.errors.tryTerminateConsumer((k<?>) kVar);
                    return;
                }
            }
            clear(aVar);
            this.errors.tryTerminateAndReport();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r2 == r0.length) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        if (r4 == false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        cancelSources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void innerComplete(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            return
        L_0x0007:
            r4 = r0[r4]     // Catch:{ all -> 0x0025 }
            r1 = 1
            if (r4 != 0) goto L_0x000e
            r4 = r1
            goto L_0x000f
        L_0x000e:
            r4 = 0
        L_0x000f:
            if (r4 != 0) goto L_0x0019
            int r2 = r3.complete     // Catch:{ all -> 0x0025 }
            int r2 = r2 + r1
            r3.complete = r2     // Catch:{ all -> 0x0025 }
            int r0 = r0.length     // Catch:{ all -> 0x0025 }
            if (r2 != r0) goto L_0x001b
        L_0x0019:
            r3.done = r1     // Catch:{ all -> 0x0025 }
        L_0x001b:
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x0021
            r3.cancelSources()
        L_0x0021:
            r3.drain()
            return
        L_0x0025:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest$LatestCoordinator.innerComplete(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        if (r1 == r4.length) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r0 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void innerError(int r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r2.errors
            boolean r4 = r0.tryAddThrowableOrReport(r4)
            if (r4 == 0) goto L_0x0035
            boolean r4 = r2.delayError
            r0 = 1
            if (r4 == 0) goto L_0x002d
            monitor-enter(r2)
            java.lang.Object[] r4 = r2.latest     // Catch:{ all -> 0x002a }
            if (r4 != 0) goto L_0x0014
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            return
        L_0x0014:
            r3 = r4[r3]     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x001a
            r3 = r0
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 != 0) goto L_0x0025
            int r1 = r2.complete     // Catch:{ all -> 0x002a }
            int r1 = r1 + r0
            r2.complete = r1     // Catch:{ all -> 0x002a }
            int r4 = r4.length     // Catch:{ all -> 0x002a }
            if (r1 != r4) goto L_0x0027
        L_0x0025:
            r2.done = r0     // Catch:{ all -> 0x002a }
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            r0 = r3
            goto L_0x002d
        L_0x002a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            throw r3
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r2.cancelSources()
        L_0x0032:
            r2.drain()
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest$LatestCoordinator.innerError(int, java.lang.Throwable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void innerNext(int r4, T r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            return
        L_0x0007:
            r1 = r0[r4]     // Catch:{ all -> 0x0029 }
            int r2 = r3.active     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0011
            int r2 = r2 + 1
            r3.active = r2     // Catch:{ all -> 0x0029 }
        L_0x0011:
            r0[r4] = r5     // Catch:{ all -> 0x0029 }
            int r4 = r0.length     // Catch:{ all -> 0x0029 }
            if (r2 != r4) goto L_0x0021
            io.reactivex.rxjava3.internal.queue.a<java.lang.Object[]> r4 = r3.queue     // Catch:{ all -> 0x0029 }
            java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0029 }
            r4.offer(r5)     // Catch:{ all -> 0x0029 }
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            if (r4 == 0) goto L_0x0028
            r3.drain()
        L_0x0028:
            return
        L_0x0029:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest$LatestCoordinator.innerNext(int, java.lang.Object):void");
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(j<? extends T>[] jVarArr) {
        ObservableCombineLatest$CombinerObserver<T, R>[] observableCombineLatest$CombinerObserverArr = this.observers;
        int length = observableCombineLatest$CombinerObserverArr.length;
        this.downstream.onSubscribe(this);
        for (int i11 = 0; i11 < length && !this.done && !this.cancelled; i11++) {
            jVarArr[i11].subscribe(observableCombineLatest$CombinerObserverArr[i11]);
        }
    }
}
