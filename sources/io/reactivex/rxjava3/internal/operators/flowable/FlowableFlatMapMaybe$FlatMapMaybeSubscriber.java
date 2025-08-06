package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import h00.f;
import h00.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = 8600231336733376951L;
    public final AtomicInteger active = new AtomicInteger(1);
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final c<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends g<? extends R>> mapper;
    public final int maxConcurrency;
    public final AtomicReference<a<R>> queue = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final CompositeDisposable set = new CompositeDisposable();
    public d upstream;

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
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(R r11) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerSuccess(this, r11);
        }
    }

    public FlowableFlatMapMaybe$FlatMapMaybeSubscriber(c<? super R> cVar, h<? super T, ? extends g<? extends R>> hVar, boolean z11, int i11) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.delayErrors = z11;
        this.maxConcurrency = i11;
    }

    public static boolean checkTerminate(boolean z11, a<?> aVar) {
        return z11 && (aVar == null || aVar.isEmpty());
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void clear() {
        a aVar = this.queue.get();
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        int i11;
        boolean z11;
        c<? super R> cVar = this.downstream;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<a<R>> atomicReference = this.queue;
        int i12 = 1;
        do {
            long j11 = this.requested.get();
            long j12 = 0;
            while (true) {
                i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                z11 = false;
                if (i11 == 0) {
                    break;
                } else if (this.cancelled) {
                    clear();
                    return;
                } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z12 = atomicInteger.get() == 0;
                    a aVar = atomicReference.get();
                    Object poll = aVar != null ? aVar.poll() : null;
                    boolean z13 = poll == null;
                    if (z12 && z13) {
                        this.errors.tryTerminateConsumer((c<?>) cVar);
                        return;
                    } else if (z13) {
                        break;
                    } else {
                        cVar.onNext(poll);
                        j12++;
                    }
                } else {
                    clear();
                    this.errors.tryTerminateConsumer((c<?>) cVar);
                    return;
                }
            }
            if (i11 == 0) {
                if (this.cancelled) {
                    clear();
                    return;
                } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z14 = atomicInteger.get() == 0;
                    a aVar2 = atomicReference.get();
                    if (aVar2 == null || aVar2.isEmpty()) {
                        z11 = true;
                    }
                    if (z14 && z11) {
                        this.errors.tryTerminateConsumer((c<?>) cVar);
                        return;
                    }
                } else {
                    clear();
                    this.errors.tryTerminateConsumer((c<?>) cVar);
                    return;
                }
            }
            if (j12 != 0) {
                io.reactivex.rxjava3.internal.util.b.e(this.requested, j12);
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(j12);
                }
            }
            i12 = addAndGet(-i12);
        } while (i12 != 0);
    }

    public a<R> getOrCreateQueue() {
        a<R> aVar = this.queue.get();
        if (aVar != null) {
            return aVar;
        }
        a<R> aVar2 = new a<>(Flowable.b());
        if (this.queue.compareAndSet((Object) null, aVar2)) {
            return aVar2;
        }
        return this.queue.get();
    }

    public void innerComplete(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
        this.set.b(innerObserver);
        if (get() == 0) {
            boolean z11 = false;
            if (compareAndSet(0, 1)) {
                if (this.active.decrementAndGet() == 0) {
                    z11 = true;
                }
                if (checkTerminate(z11, this.queue.get())) {
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    return;
                }
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1);
                }
                if (decrementAndGet() != 0) {
                    drainLoop();
                    return;
                }
                return;
            }
        }
        this.active.decrementAndGet();
        if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
        drain();
    }

    public void innerError(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
        this.set.b(innerObserver);
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1);
            }
            this.active.decrementAndGet();
            drain();
        }
    }

    public void innerSuccess(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r11) {
        this.set.b(innerObserver);
        if (get() == 0) {
            boolean z11 = false;
            if (compareAndSet(0, 1)) {
                if (this.active.decrementAndGet() == 0) {
                    z11 = true;
                }
                if (this.requested.get() != 0) {
                    this.downstream.onNext(r11);
                    if (checkTerminate(z11, this.queue.get())) {
                        this.errors.tryTerminateConsumer((c<?>) this.downstream);
                        return;
                    }
                    io.reactivex.rxjava3.internal.util.b.e(this.requested, 1);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1);
                    }
                } else {
                    a orCreateQueue = getOrCreateQueue();
                    synchronized (orCreateQueue) {
                        orCreateQueue.offer(r11);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
            }
        }
        a orCreateQueue2 = getOrCreateQueue();
        synchronized (orCreateQueue2) {
            orCreateQueue2.offer(r11);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
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
            this.upstream.cancel();
            onError(th2);
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            int i11 = this.maxConcurrency;
            if (i11 == Integer.MAX_VALUE) {
                dVar.request(Long.MAX_VALUE);
            } else {
                dVar.request((long) i11);
            }
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            drain();
        }
    }
}
