package io.reactivex.rxjava3.internal.operators.mixed;

import h00.a;
import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class FlowableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements e<T>, b {
    private static final long serialVersionUID = 3610901111000061034L;
    public volatile boolean active;
    public int consumed;
    public volatile boolean disposed;
    public volatile boolean done;
    public final a downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
    public final h<? super T, ? extends h00.b> mapper;
    public final int prefetch;
    public final k00.e<T> queue;
    public d upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<b> implements a {
        private static final long serialVersionUID = 5638352172918776687L;
        public final FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> flowableConcatMapCompletable$ConcatMapCompletableObserver) {
            this.parent = flowableConcatMapCompletable$ConcatMapCompletableObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.innerComplete();
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public FlowableConcatMapCompletable$ConcatMapCompletableObserver(a aVar, h<? super T, ? extends h00.b> hVar, ErrorMode errorMode2, int i11) {
        this.downstream = aVar;
        this.mapper = hVar;
        this.errorMode = errorMode2;
        this.prefetch = i11;
        this.queue = new SpscArrayQueue(i11);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.inner.dispose();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            while (!this.disposed) {
                if (!this.active) {
                    if (this.errorMode != ErrorMode.BOUNDARY || this.errors.get() == null) {
                        boolean z11 = this.done;
                        T poll = this.queue.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        } else if (!z12) {
                            int i11 = this.prefetch;
                            int i12 = i11 - (i11 >> 1);
                            int i13 = this.consumed + 1;
                            if (i13 == i12) {
                                this.consumed = 0;
                                this.upstream.request((long) i12);
                            } else {
                                this.consumed = i13;
                            }
                            try {
                                Object apply = this.mapper.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                h00.b bVar = (h00.b) apply;
                                this.active = true;
                                bVar.a(this.inner);
                            } catch (Throwable th2) {
                                io.reactivex.rxjava3.exceptions.a.b(th2);
                                this.queue.clear();
                                this.upstream.cancel();
                                this.errors.tryAddThrowableOrReport(th2);
                                this.errors.tryTerminateConsumer(this.downstream);
                                return;
                            }
                        }
                    } else {
                        this.queue.clear();
                        this.errors.tryTerminateConsumer(this.downstream);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable th2) {
        if (!this.errors.tryAddThrowableOrReport(th2)) {
            return;
        }
        if (this.errorMode == ErrorMode.IMMEDIATE) {
            this.upstream.cancel();
            this.errors.tryTerminateConsumer(this.downstream);
            if (getAndIncrement() == 0) {
                this.queue.clear();
                return;
            }
            return;
        }
        this.active = false;
        drain();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (!this.errors.tryAddThrowableOrReport(th2)) {
            return;
        }
        if (this.errorMode == ErrorMode.IMMEDIATE) {
            this.inner.dispose();
            this.errors.tryTerminateConsumer(this.downstream);
            if (getAndIncrement() == 0) {
                this.queue.clear();
                return;
            }
            return;
        }
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (this.queue.offer(t11)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue full?!"));
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request((long) this.prefetch);
        }
    }
}
