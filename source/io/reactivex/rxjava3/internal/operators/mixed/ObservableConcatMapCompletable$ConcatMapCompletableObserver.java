package io.reactivex.rxjava3.internal.operators.mixed;

import h00.a;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;

final class ObservableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = 3610901111000061034L;
    public volatile boolean active;
    public volatile boolean disposed;
    public volatile boolean done;
    public final a downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
    public final h<? super T, ? extends h00.b> mapper;
    public final int prefetch;
    public f<T> queue;
    public b upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<b> implements a {
        private static final long serialVersionUID = 5638352172918776687L;
        public final ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> observableConcatMapCompletable$ConcatMapCompletableObserver) {
            this.parent = observableConcatMapCompletable$ConcatMapCompletableObserver;
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

    public ObservableConcatMapCompletable$ConcatMapCompletableObserver(a aVar, h<? super T, ? extends h00.b> hVar, ErrorMode errorMode2, int i11) {
        this.downstream = aVar;
        this.mapper = hVar;
        this.errorMode = errorMode2;
        this.prefetch = i11;
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.inner.dispose();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        boolean z11;
        if (getAndIncrement() == 0) {
            AtomicThrowable atomicThrowable = this.errors;
            ErrorMode errorMode2 = this.errorMode;
            while (!this.disposed) {
                if (!this.active) {
                    if (errorMode2 != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                        boolean z12 = this.done;
                        h00.b bVar = null;
                        try {
                            T poll = this.queue.poll();
                            if (poll != null) {
                                Object apply = this.mapper.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                bVar = (h00.b) apply;
                                z11 = false;
                            } else {
                                z11 = true;
                            }
                            if (z12 && z11) {
                                this.disposed = true;
                                atomicThrowable.tryTerminateConsumer(this.downstream);
                                return;
                            } else if (!z11) {
                                this.active = true;
                                bVar.a(this.inner);
                            }
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            this.disposed = true;
                            this.queue.clear();
                            this.upstream.dispose();
                            atomicThrowable.tryAddThrowableOrReport(th2);
                            atomicThrowable.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    } else {
                        this.disposed = true;
                        this.queue.clear();
                        atomicThrowable.tryTerminateConsumer(this.downstream);
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
            this.disposed = true;
            this.upstream.dispose();
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
            this.disposed = true;
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
        if (t11 != null) {
            this.queue.offer(t11);
        }
        drain();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof k00.b) {
                k00.b bVar2 = (k00.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.queue = bVar2;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.rxjava3.internal.queue.a(this.prefetch);
            this.downstream.onSubscribe(this);
        }
    }
}
