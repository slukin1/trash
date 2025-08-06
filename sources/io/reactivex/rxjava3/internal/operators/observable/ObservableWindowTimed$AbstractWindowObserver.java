package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k00.e;

abstract class ObservableWindowTimed$AbstractWindowObserver<T> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = 5724293814035355511L;
    public final int bufferSize;
    public volatile boolean done;
    public final k<? super Observable<T>> downstream;
    public final AtomicBoolean downstreamCancelled;
    public long emitted;
    public Throwable error;
    public final e<Object> queue = new MpscLinkedQueue();
    public final long timespan;
    public final TimeUnit unit;
    public b upstream;
    public volatile boolean upstreamCancelled;
    public final AtomicInteger windowCount;

    public ObservableWindowTimed$AbstractWindowObserver(k<? super Observable<T>> kVar, long j11, TimeUnit timeUnit, int i11) {
        this.downstream = kVar;
        this.timespan = j11;
        this.unit = timeUnit;
        this.bufferSize = i11;
        this.downstreamCancelled = new AtomicBoolean();
        this.windowCount = new AtomicInteger(1);
    }

    /* access modifiers changed from: package-private */
    public abstract void cleanupResources();

    /* access modifiers changed from: package-private */
    public abstract void createFirstWindow();

    public final void dispose() {
        if (this.downstreamCancelled.compareAndSet(false, true)) {
            windowDone();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void drain();

    public final boolean isDisposed() {
        return this.downstreamCancelled.get();
    }

    public final void onComplete() {
        this.done = true;
        drain();
    }

    public final void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public final void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public final void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            createFirstWindow();
        }
    }

    /* access modifiers changed from: package-private */
    public final void windowDone() {
        if (this.windowCount.decrementAndGet() == 0) {
            cleanupResources();
            this.upstream.dispose();
            this.upstreamCancelled = true;
            drain();
        }
    }
}
