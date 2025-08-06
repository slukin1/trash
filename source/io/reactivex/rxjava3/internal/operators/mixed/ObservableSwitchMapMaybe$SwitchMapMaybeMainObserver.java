package io.reactivex.rxjava3.internal.operators.mixed;

import h00.f;
import h00.g;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements k<T>, b {
    public static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>((ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver) null);
    private static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
    public final h<? super T, ? extends g<? extends R>> mapper;
    public b upstream;

    public static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements f<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        public volatile R item;
        public final ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> parent;

        public SwitchMapMaybeObserver(ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> observableSwitchMapMaybe$SwitchMapMaybeMainObserver) {
            this.parent = observableSwitchMapMaybe$SwitchMapMaybeMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.innerComplete(this);
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

    public ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(k<? super R> kVar, h<? super T, ? extends g<? extends R>> hVar, boolean z11) {
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
        AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver = INNER_DISPOSED;
        SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
        if (andSet != null && andSet != switchMapMaybeObserver) {
            andSet.dispose();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super R> kVar = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            int i11 = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() == null || this.delayErrors) {
                    boolean z11 = this.done;
                    SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                    boolean z12 = switchMapMaybeObserver == null;
                    if (z11 && z12) {
                        atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                        return;
                    } else if (z12 || switchMapMaybeObserver.item == null) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.compareAndSet(switchMapMaybeObserver, (Object) null);
                        kVar.onNext(switchMapMaybeObserver.item);
                    }
                } else {
                    atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                    return;
                }
            }
        }
    }

    public void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
        if (this.inner.compareAndSet(switchMapMaybeObserver, (Object) null)) {
            drain();
        }
    }

    public void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
        if (!this.inner.compareAndSet(switchMapMaybeObserver, (Object) null)) {
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
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
        SwitchMapMaybeObserver switchMapMaybeObserver2 = this.inner.get();
        if (switchMapMaybeObserver2 != null) {
            switchMapMaybeObserver2.dispose();
        }
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            g gVar = (g) apply;
            SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
            do {
                switchMapMaybeObserver = this.inner.get();
                if (switchMapMaybeObserver == INNER_DISPOSED) {
                    return;
                }
            } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
            gVar.a(switchMapMaybeObserver3);
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
