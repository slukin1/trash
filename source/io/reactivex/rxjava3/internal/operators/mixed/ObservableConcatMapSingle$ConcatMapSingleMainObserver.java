package io.reactivex.rxjava3.internal.operators.mixed;

import h00.k;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.e;

final class ObservableConcatMapSingle$ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements k<T>, b {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_INACTIVE = 0;
    public static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
    public R item;
    public final h<? super T, ? extends o<? extends R>> mapper;
    public final e<T> queue;
    public volatile int state;
    public b upstream;

    public static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements m<R> {
        private static final long serialVersionUID = -3051469169682093892L;
        public final ObservableConcatMapSingle$ConcatMapSingleMainObserver<?, R> parent;

        public ConcatMapSingleObserver(ObservableConcatMapSingle$ConcatMapSingleMainObserver<?, R> observableConcatMapSingle$ConcatMapSingleMainObserver) {
            this.parent = observableConcatMapSingle$ConcatMapSingleMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        public void onSuccess(R r11) {
            this.parent.innerSuccess(r11);
        }
    }

    public ObservableConcatMapSingle$ConcatMapSingleMainObserver(k<? super R> kVar, h<? super T, ? extends o<? extends R>> hVar, int i11, ErrorMode errorMode2) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.errorMode = errorMode2;
        this.queue = new a(i11);
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.inner.dispose();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue.clear();
            this.item = null;
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super R> kVar = this.downstream;
            ErrorMode errorMode2 = this.errorMode;
            e<T> eVar = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int i11 = 1;
            while (true) {
                if (this.cancelled) {
                    eVar.clear();
                    this.item = null;
                } else {
                    int i12 = this.state;
                    if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i12 == 0))) {
                        boolean z11 = false;
                        if (i12 == 0) {
                            boolean z12 = this.done;
                            T poll = eVar.poll();
                            if (poll == null) {
                                z11 = true;
                            }
                            if (z12 && z11) {
                                atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                                return;
                            } else if (!z11) {
                                try {
                                    Object apply = this.mapper.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                    o oVar = (o) apply;
                                    this.state = 1;
                                    oVar.a(this.inner);
                                } catch (Throwable th2) {
                                    io.reactivex.rxjava3.exceptions.a.b(th2);
                                    this.upstream.dispose();
                                    eVar.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th2);
                                    atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                                    return;
                                }
                            }
                        } else if (i12 == 2) {
                            R r11 = this.item;
                            this.item = null;
                            kVar.onNext(r11);
                            this.state = 0;
                        }
                    }
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
            eVar.clear();
            this.item = null;
            atomicThrowable.tryTerminateConsumer((k<?>) kVar);
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode != ErrorMode.END) {
                this.upstream.dispose();
            }
            this.state = 0;
            drain();
        }
    }

    public void innerSuccess(R r11) {
        this.item = r11;
        this.state = 2;
        drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
            }
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
