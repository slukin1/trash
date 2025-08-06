package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableSwitchMap$SwitchMapObserver<T, R> extends AtomicInteger implements k<T>, b {
    public static final ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    public final AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final AtomicThrowable errors;
    public final h<? super T, ? extends j<? extends R>> mapper;
    public volatile long unique;
    public b upstream;

    static {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver = new ObservableSwitchMap$SwitchMapInnerObserver<>((ObservableSwitchMap$SwitchMapObserver) null, -1, 1);
        CANCELLED = observableSwitchMap$SwitchMapInnerObserver;
        observableSwitchMap$SwitchMapInnerObserver.cancel();
    }

    public ObservableSwitchMap$SwitchMapObserver(k<? super R> kVar, h<? super T, ? extends j<? extends R>> hVar, int i11, boolean z11) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.bufferSize = i11;
        this.delayErrors = z11;
        this.errors = new AtomicThrowable();
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }
    }

    public void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver andSet = this.active.getAndSet(CANCELLED);
        if (andSet != null) {
            andSet.cancel();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x000f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r13 = this;
            int r0 = r13.getAndIncrement()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            h00.k<? super R> r0 = r13.downstream
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r1 = r13.active
            boolean r2 = r13.delayErrors
            r3 = 1
            r4 = r3
        L_0x000f:
            boolean r5 = r13.cancelled
            if (r5 == 0) goto L_0x0014
            return
        L_0x0014:
            boolean r5 = r13.done
            r6 = 0
            if (r5 == 0) goto L_0x004e
            java.lang.Object r5 = r1.get()
            if (r5 != 0) goto L_0x0021
            r5 = r3
            goto L_0x0022
        L_0x0021:
            r5 = r6
        L_0x0022:
            if (r2 == 0) goto L_0x0038
            if (r5 == 0) goto L_0x004e
            io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.errors
            java.lang.Object r1 = r1.get()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0034
            r0.onError(r1)
            goto L_0x0037
        L_0x0034:
            r0.onComplete()
        L_0x0037:
            return
        L_0x0038:
            io.reactivex.rxjava3.internal.util.AtomicThrowable r7 = r13.errors
            java.lang.Object r7 = r7.get()
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 == 0) goto L_0x0048
            io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.errors
            r1.tryTerminateConsumer((h00.k<?>) r0)
            return
        L_0x0048:
            if (r5 == 0) goto L_0x004e
            r0.onComplete()
            return
        L_0x004e:
            java.lang.Object r5 = r1.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver r5 = (io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver) r5
            if (r5 == 0) goto L_0x00b7
            k00.f<R> r7 = r5.queue
            if (r7 == 0) goto L_0x00b7
            r8 = r6
        L_0x005b:
            boolean r9 = r13.cancelled
            if (r9 == 0) goto L_0x0060
            return
        L_0x0060:
            java.lang.Object r9 = r1.get()
            if (r5 == r9) goto L_0x0068
        L_0x0066:
            r8 = r3
            goto L_0x00af
        L_0x0068:
            if (r2 != 0) goto L_0x007a
            io.reactivex.rxjava3.internal.util.AtomicThrowable r9 = r13.errors
            java.lang.Object r9 = r9.get()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            if (r9 == 0) goto L_0x007a
            io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.errors
            r1.tryTerminateConsumer((h00.k<?>) r0)
            return
        L_0x007a:
            boolean r9 = r5.done
            r10 = 0
            java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x0082 }
            goto L_0x00a0
        L_0x0082:
            r8 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r8)
            io.reactivex.rxjava3.internal.util.AtomicThrowable r11 = r13.errors
            r11.tryAddThrowableOrReport(r8)
            r1.compareAndSet(r5, r10)
            if (r2 != 0) goto L_0x009b
            r13.disposeInner()
            io.reactivex.rxjava3.disposables.b r8 = r13.upstream
            r8.dispose()
            r13.done = r3
            goto L_0x009e
        L_0x009b:
            r5.cancel()
        L_0x009e:
            r8 = r3
            r11 = r10
        L_0x00a0:
            if (r11 != 0) goto L_0x00a4
            r12 = r3
            goto L_0x00a5
        L_0x00a4:
            r12 = r6
        L_0x00a5:
            if (r9 == 0) goto L_0x00ad
            if (r12 == 0) goto L_0x00ad
            r1.compareAndSet(r5, r10)
            goto L_0x0066
        L_0x00ad:
            if (r12 == 0) goto L_0x00b3
        L_0x00af:
            if (r8 == 0) goto L_0x00b7
            goto L_0x000f
        L_0x00b3:
            r0.onNext(r11)
            goto L_0x005b
        L_0x00b7:
            int r4 = -r4
            int r4 = r13.addAndGet(r4)
            if (r4 != 0) goto L_0x000f
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapObserver.drain():void");
    }

    public void innerError(ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver, Throwable th2) {
        if (observableSwitchMap$SwitchMapInnerObserver.index != this.unique || !this.errors.tryAddThrowable(th2)) {
            a.n(th2);
            return;
        }
        if (!this.delayErrors) {
            this.upstream.dispose();
            this.done = true;
        }
        observableSwitchMap$SwitchMapInnerObserver.done = true;
        drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done || !this.errors.tryAddThrowable(th2)) {
            a.n(th2);
            return;
        }
        if (!this.delayErrors) {
            disposeInner();
        }
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver;
        long j11 = this.unique + 1;
        this.unique = j11;
        ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver2 = this.active.get();
        if (observableSwitchMap$SwitchMapInnerObserver2 != null) {
            observableSwitchMap$SwitchMapInnerObserver2.cancel();
        }
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The ObservableSource returned is null");
            j jVar = (j) apply;
            ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver3 = new ObservableSwitchMap$SwitchMapInnerObserver(this, j11, this.bufferSize);
            do {
                observableSwitchMap$SwitchMapInnerObserver = this.active.get();
                if (observableSwitchMap$SwitchMapInnerObserver == CANCELLED) {
                    return;
                }
            } while (!this.active.compareAndSet(observableSwitchMap$SwitchMapInnerObserver, observableSwitchMap$SwitchMapInnerObserver3));
            jVar.subscribe(observableSwitchMap$SwitchMapInnerObserver3);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.upstream.dispose();
            onError(th2);
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
