package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableThrottleLatest$ThrottleLatestObserver<T> extends AtomicInteger implements k<T>, b, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final k<? super T> downstream;
    public final boolean emitLast;
    public Throwable error;
    public final AtomicReference<T> latest = new AtomicReference<>();
    public final long timeout;
    public volatile boolean timerFired;
    public boolean timerRunning;
    public final TimeUnit unit;
    public b upstream;
    public final Scheduler.Worker worker;

    public ObservableThrottleLatest$ThrottleLatestObserver(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler.Worker worker2, boolean z11) {
        this.downstream = kVar;
        this.timeout = j11;
        this.unit = timeUnit;
        this.worker = worker2;
        this.emitLast = z11;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.latest.lazySet((Object) null);
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            AtomicReference<T> atomicReference = this.latest;
            k<? super T> kVar = this.downstream;
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = this.done;
                if (!z11 || this.error == null) {
                    boolean z12 = atomicReference.get() == null;
                    if (z11) {
                        T andSet = atomicReference.getAndSet((Object) null);
                        if (!z12 && this.emitLast) {
                            kVar.onNext(andSet);
                        }
                        kVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    if (z12) {
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                    } else if (!this.timerRunning || this.timerFired) {
                        kVar.onNext(atomicReference.getAndSet((Object) null));
                        this.timerFired = false;
                        this.timerRunning = true;
                        this.worker.c(this, this.timeout, this.unit);
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    atomicReference.lazySet((Object) null);
                    kVar.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
            atomicReference.lazySet((Object) null);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.latest.set(t11);
        drain();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        this.timerFired = true;
        drain();
    }
}
