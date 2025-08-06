package io.reactivex.rxjava3.internal.operators.observable;

import h00.f;
import h00.g;
import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = 8600231336733376951L;
    public final AtomicInteger active = new AtomicInteger(1);
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final k<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends g<? extends R>> mapper;
    public final AtomicReference<a<R>> queue = new AtomicReference<>();
    public final CompositeDisposable set = new CompositeDisposable();
    public b upstream;

    public final class InnerObserver extends AtomicReference<b> implements f<R>, b {
        private static final long serialVersionUID = -502562646270949838L;

        public InnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void onComplete() {
            ObservableFlatMapMaybe$FlatMapMaybeObserver.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            ObservableFlatMapMaybe$FlatMapMaybeObserver.this.innerError(this, th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(R r11) {
            ObservableFlatMapMaybe$FlatMapMaybeObserver.this.innerSuccess(this, r11);
        }
    }

    public ObservableFlatMapMaybe$FlatMapMaybeObserver(k<? super R> kVar, h<? super T, ? extends g<? extends R>> hVar, boolean z11) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.delayErrors = z11;
    }

    public void clear() {
        a aVar = this.queue.get();
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.set.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        k<? super R> kVar = this.downstream;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<a<R>> atomicReference = this.queue;
        int i11 = 1;
        while (!this.cancelled) {
            if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                boolean z11 = false;
                boolean z12 = atomicInteger.get() == 0;
                a aVar = atomicReference.get();
                Object poll = aVar != null ? aVar.poll() : null;
                if (poll == null) {
                    z11 = true;
                }
                if (z12 && z11) {
                    this.errors.tryTerminateConsumer((k<?>) kVar);
                    return;
                } else if (z11) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    kVar.onNext(poll);
                }
            } else {
                clear();
                this.errors.tryTerminateConsumer((k<?>) kVar);
                return;
            }
        }
        clear();
    }

    public a<R> getOrCreateQueue() {
        a<R> aVar = this.queue.get();
        if (aVar != null) {
            return aVar;
        }
        a<R> aVar2 = new a<>(Observable.a());
        if (this.queue.compareAndSet((Object) null, aVar2)) {
            return aVar2;
        }
        return this.queue.get();
    }

    public void innerComplete(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
        this.set.b(innerObserver);
        if (get() == 0) {
            boolean z11 = false;
            if (compareAndSet(0, 1)) {
                if (this.active.decrementAndGet() == 0) {
                    z11 = true;
                }
                a aVar = this.queue.get();
                if (z11 && (aVar == null || aVar.isEmpty())) {
                    this.errors.tryTerminateConsumer((k<?>) this.downstream);
                    return;
                } else if (decrementAndGet() != 0) {
                    drainLoop();
                    return;
                } else {
                    return;
                }
            }
        }
        this.active.decrementAndGet();
        drain();
    }

    public void innerError(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
        this.set.b(innerObserver);
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }
    }

    public void innerSuccess(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r11) {
        this.set.b(innerObserver);
        if (get() == 0) {
            boolean z11 = false;
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(r11);
                if (this.active.decrementAndGet() == 0) {
                    z11 = true;
                }
                a aVar = this.queue.get();
                if (!z11 || (aVar != null && !aVar.isEmpty())) {
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
                this.errors.tryTerminateConsumer((k<?>) this.downstream);
                return;
            }
        }
        a orCreateQueue = getOrCreateQueue();
        synchronized (orCreateQueue) {
            orCreateQueue.offer(r11);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    public void onError(Throwable th2) {
        this.active.decrementAndGet();
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }
    }

    public void onNext(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            g gVar = (g) apply;
            this.active.getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (!this.cancelled && this.set.a(innerObserver)) {
                gVar.a(innerObserver);
            }
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
