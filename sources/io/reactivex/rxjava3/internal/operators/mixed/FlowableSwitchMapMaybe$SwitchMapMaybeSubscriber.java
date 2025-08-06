package io.reactivex.rxjava3.internal.operators.mixed;

import h00.e;
import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.c;
import z20.d;

final class FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements e<T>, d {
    public static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>((FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber) null);
    private static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final c<? super R> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
    public final h<? super T, ? extends g<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;

    public static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements f<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        public volatile R item;
        public final FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<?, R> parent;

        public SwitchMapMaybeObserver(FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<?, R> flowableSwitchMapMaybe$SwitchMapMaybeSubscriber) {
            this.parent = flowableSwitchMapMaybe$SwitchMapMaybeSubscriber;
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

    public FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber(c<? super R> cVar, h<? super T, ? extends g<? extends R>> hVar, boolean z11) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.delayErrors = z11;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
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
            c<? super R> cVar = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j11 = this.emitted;
            int i11 = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() == null || this.delayErrors) {
                    boolean z11 = this.done;
                    SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                    boolean z12 = switchMapMaybeObserver == null;
                    if (z11 && z12) {
                        atomicThrowable.tryTerminateConsumer((c<?>) cVar);
                        return;
                    } else if (z12 || switchMapMaybeObserver.item == null || j11 == atomicLong.get()) {
                        this.emitted = j11;
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.compareAndSet(switchMapMaybeObserver, (Object) null);
                        cVar.onNext(switchMapMaybeObserver.item);
                        j11++;
                    }
                } else {
                    atomicThrowable.tryTerminateConsumer((c<?>) cVar);
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
                this.upstream.cancel();
                disposeInner();
            }
            drain();
        }
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
            this.upstream.cancel();
            this.inner.getAndSet(INNER_DISPOSED);
            onError(th2);
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        drain();
    }
}
