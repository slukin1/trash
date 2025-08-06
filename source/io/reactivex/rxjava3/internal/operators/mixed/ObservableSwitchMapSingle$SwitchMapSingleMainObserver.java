package io.reactivex.rxjava3.internal.operators.mixed;

import h00.k;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableSwitchMapSingle$SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements k<T>, b {
    public static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver<>((ObservableSwitchMapSingle$SwitchMapSingleMainObserver) null);
    private static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
    public final h<? super T, ? extends o<? extends R>> mapper;
    public b upstream;

    public static final class SwitchMapSingleObserver<R> extends AtomicReference<b> implements m<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        public volatile R item;
        public final ObservableSwitchMapSingle$SwitchMapSingleMainObserver<?, R> parent;

        public SwitchMapSingleObserver(ObservableSwitchMapSingle$SwitchMapSingleMainObserver<?, R> observableSwitchMapSingle$SwitchMapSingleMainObserver) {
            this.parent = observableSwitchMapSingle$SwitchMapSingleMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(this, th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(R r11) {
            this.item = r11;
            this.parent.drain();
        }
    }

    public ObservableSwitchMapSingle$SwitchMapSingleMainObserver(k<? super R> kVar, h<? super T, ? extends o<? extends R>> hVar, boolean z11) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.delayErrors = z11;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
        this.errors.tryTerminateAndReport();
    }

    public void disposeInner() {
        AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
        SwitchMapSingleObserver<Object> switchMapSingleObserver = INNER_DISPOSED;
        SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
        if (andSet != null && andSet != switchMapSingleObserver) {
            andSet.dispose();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super R> kVar = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            int i11 = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() == null || this.delayErrors) {
                    boolean z11 = this.done;
                    SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                    boolean z12 = switchMapSingleObserver == null;
                    if (z11 && z12) {
                        atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                        return;
                    } else if (z12 || switchMapSingleObserver.item == null) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.compareAndSet(switchMapSingleObserver, (Object) null);
                        kVar.onNext(switchMapSingleObserver.item);
                    }
                } else {
                    atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                    return;
                }
            }
        }
    }

    public void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
        if (!this.inner.compareAndSet(switchMapSingleObserver, (Object) null)) {
            a.n(th2);
        } else if (this.errors.tryAddThrowableOrReport(th2)) {
            if (!this.delayErrors) {
                this.upstream.dispose();
                disposeInner();
            }
            drain();
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
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        SwitchMapSingleObserver<Object> switchMapSingleObserver;
        SwitchMapSingleObserver switchMapSingleObserver2 = this.inner.get();
        if (switchMapSingleObserver2 != null) {
            switchMapSingleObserver2.dispose();
        }
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            o oVar = (o) apply;
            SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
            do {
                switchMapSingleObserver = this.inner.get();
                if (switchMapSingleObserver == INNER_DISPOSED) {
                    return;
                }
            } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
            oVar.a(switchMapSingleObserver3);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.upstream.dispose();
            this.inner.getAndSet(INNER_DISPOSED);
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
