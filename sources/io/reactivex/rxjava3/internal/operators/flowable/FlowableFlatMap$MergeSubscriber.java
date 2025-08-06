package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import j00.k;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.b;
import z20.c;
import z20.d;

final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements e<T>, d {
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = new FlowableFlatMap$InnerSubscriber[0];
    private static final long serialVersionUID = -2117620485640801370L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final c<? super U> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public long lastId;
    public int lastIndex;
    public final h<? super T, ? extends b<? extends U>> mapper;
    public final int maxConcurrency;
    public volatile k00.e<U> queue;
    public final AtomicLong requested;
    public int scalarEmitted;
    public final int scalarLimit;
    public final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers;
    public long uniqueId;
    public d upstream;

    public FlowableFlatMap$MergeSubscriber(c<? super U> cVar, h<? super T, ? extends b<? extends U>> hVar, boolean z11, int i11, int i12) {
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
        this.subscribers = atomicReference;
        this.requested = new AtomicLong();
        this.downstream = cVar;
        this.mapper = hVar;
        this.delayErrors = z11;
        this.maxConcurrency = i11;
        this.bufferSize = i12;
        this.scalarLimit = Math.max(1, i11 >> 1);
        atomicReference.lazySet(EMPTY);
    }

    public boolean addInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
            if (flowableFlatMap$InnerSubscriberArr == CANCELLED) {
                flowableFlatMap$InnerSubscriber.dispose();
                return false;
            }
            int length = flowableFlatMap$InnerSubscriberArr.length;
            flowableFlatMap$InnerSubscriberArr2 = new FlowableFlatMap$InnerSubscriber[(length + 1)];
            System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr2, 0, length);
            flowableFlatMap$InnerSubscriberArr2[length] = flowableFlatMap$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
        return true;
    }

    public void cancel() {
        k00.e<U> eVar;
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() == 0 && (eVar = this.queue) != null) {
                eVar.clear();
            }
        }
    }

    public boolean checkTerminate() {
        if (this.cancelled) {
            clearScalarQueue();
            return true;
        } else if (this.delayErrors || this.errors.get() == null) {
            return false;
        } else {
            clearScalarQueue();
            this.errors.tryTerminateConsumer((c<?>) this.downstream);
            return true;
        }
    }

    public void clearScalarQueue() {
        k00.e<U> eVar = this.queue;
        if (eVar != null) {
            eVar.clear();
        }
    }

    public void disposeAll() {
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> atomicReference = this.subscribers;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr = CANCELLED;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = (FlowableFlatMap$InnerSubscriber[]) atomicReference.getAndSet(flowableFlatMap$InnerSubscriberArr);
        if (flowableFlatMap$InnerSubscriberArr2 != flowableFlatMap$InnerSubscriberArr) {
            for (FlowableFlatMap$InnerSubscriber<?, ?> dispose : flowableFlatMap$InnerSubscriberArr2) {
                dispose.dispose();
            }
            this.errors.tryTerminateAndReport();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        long j11;
        long j12;
        boolean z11;
        long j13;
        long j14;
        int i11;
        int i12;
        long j15;
        long j16;
        c<? super U> cVar = this.downstream;
        int i13 = 1;
        while (!checkTerminate()) {
            k00.e<U> eVar = this.queue;
            long j17 = this.requested.get();
            boolean z12 = j17 == Long.MAX_VALUE;
            long j18 = 0;
            if (eVar != null) {
                long j19 = 0;
                j11 = 0;
                while (j17 != 0) {
                    U poll = eVar.poll();
                    if (!checkTerminate()) {
                        if (poll == null) {
                            break;
                        }
                        cVar.onNext(poll);
                        j11++;
                        j19++;
                        j17--;
                    } else {
                        return;
                    }
                }
                if (j19 != 0) {
                    if (z12) {
                        j17 = Long.MAX_VALUE;
                    } else {
                        j17 = this.requested.addAndGet(-j19);
                    }
                }
            } else {
                j11 = 0;
            }
            boolean z13 = this.done;
            k00.e<U> eVar2 = this.queue;
            FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr.length;
            if (!z13 || ((eVar2 != null && !eVar2.isEmpty()) || length != 0)) {
                int i14 = i13;
                if (length != 0) {
                    long j21 = this.lastId;
                    int i15 = this.lastIndex;
                    if (length <= i15 || flowableFlatMap$InnerSubscriberArr[i15].f55484id != j21) {
                        if (length <= i15) {
                            i15 = 0;
                        }
                        for (int i16 = 0; i16 < length && flowableFlatMap$InnerSubscriberArr[i15].f55484id != j21; i16++) {
                            i15++;
                            if (i15 == length) {
                                i15 = 0;
                            }
                        }
                        this.lastIndex = i15;
                        this.lastId = flowableFlatMap$InnerSubscriberArr[i15].f55484id;
                    }
                    int i17 = i15;
                    boolean z14 = false;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= length) {
                            z11 = z14;
                            break;
                        } else if (!checkTerminate()) {
                            FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber = flowableFlatMap$InnerSubscriberArr[i17];
                            U u11 = null;
                            while (true) {
                                f<U> fVar = flowableFlatMap$InnerSubscriber.queue;
                                if (fVar != null) {
                                    i11 = length;
                                    U u12 = u11;
                                    long j22 = j18;
                                    while (true) {
                                        if (j12 == j18) {
                                            j15 = j18;
                                            break;
                                        } else if (!checkTerminate()) {
                                            try {
                                                U poll2 = fVar.poll();
                                                if (poll2 == null) {
                                                    u12 = poll2;
                                                    j15 = 0;
                                                    break;
                                                }
                                                cVar.onNext(poll2);
                                                j12--;
                                                j22++;
                                                u12 = poll2;
                                                j18 = 0;
                                            } catch (Throwable th2) {
                                                Throwable th3 = th2;
                                                a.b(th3);
                                                flowableFlatMap$InnerSubscriber.dispose();
                                                this.errors.tryAddThrowableOrReport(th3);
                                                if (!this.delayErrors) {
                                                    this.upstream.cancel();
                                                }
                                                if (!checkTerminate()) {
                                                    removeInner(flowableFlatMap$InnerSubscriber);
                                                    i18++;
                                                    i12 = i11;
                                                    z14 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j22 != j15) {
                                        j12 = !z12 ? this.requested.addAndGet(-j22) : Long.MAX_VALUE;
                                        flowableFlatMap$InnerSubscriber.requestMore(j22);
                                        j16 = 0;
                                    } else {
                                        j16 = j15;
                                    }
                                    if (j12 == j16 || u12 == null) {
                                        break;
                                    }
                                    length = i11;
                                    u11 = u12;
                                    j18 = 0;
                                } else {
                                    i11 = length;
                                    break;
                                }
                            }
                            boolean z15 = flowableFlatMap$InnerSubscriber.done;
                            f<U> fVar2 = flowableFlatMap$InnerSubscriber.queue;
                            if (z15 && (fVar2 == null || fVar2.isEmpty())) {
                                removeInner(flowableFlatMap$InnerSubscriber);
                                if (!checkTerminate()) {
                                    j11++;
                                    z14 = true;
                                } else {
                                    return;
                                }
                            }
                            if (j12 == 0) {
                                z11 = z14;
                                break;
                            }
                            i17++;
                            i12 = i11;
                            if (i17 == i12) {
                                i17 = 0;
                            }
                            i18++;
                            length = i12;
                            j18 = 0;
                        } else {
                            return;
                        }
                    }
                    this.lastIndex = i17;
                    this.lastId = flowableFlatMap$InnerSubscriberArr[i17].f55484id;
                    j14 = j11;
                    j13 = 0;
                } else {
                    j13 = 0;
                    j14 = j11;
                    z11 = false;
                }
                if (j14 != j13 && !this.cancelled) {
                    this.upstream.request(j14);
                }
                if (z11) {
                    i13 = i14;
                } else {
                    i13 = addAndGet(-i14);
                    if (i13 == 0) {
                        return;
                    }
                }
            } else {
                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                return;
            }
        }
    }

    public f<U> getMainQueue() {
        k00.e<U> eVar = this.queue;
        if (eVar == null) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                eVar = new io.reactivex.rxjava3.internal.queue.a<>(this.bufferSize);
            } else {
                eVar = new SpscArrayQueue<>(this.maxConcurrency);
            }
            this.queue = eVar;
        }
        return eVar;
    }

    public void innerError(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber, Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            flowableFlatMap$InnerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (FlowableFlatMap$InnerSubscriber dispose : (FlowableFlatMap$InnerSubscriber[]) this.subscribers.getAndSet(CANCELLED)) {
                    dispose.dispose();
                }
            }
            drain();
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
        } else if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            if (!this.delayErrors) {
                for (FlowableFlatMap$InnerSubscriber dispose : (FlowableFlatMap$InnerSubscriber[]) this.subscribers.getAndSet(CANCELLED)) {
                    dispose.dispose();
                }
            }
            drain();
        }
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                Object apply = this.mapper.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                b bVar = (b) apply;
                if (bVar instanceof k) {
                    try {
                        Object obj = ((k) bVar).get();
                        if (obj != null) {
                            tryEmitScalar(obj);
                        } else if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                            int i11 = this.scalarEmitted + 1;
                            this.scalarEmitted = i11;
                            int i12 = this.scalarLimit;
                            if (i11 == i12) {
                                this.scalarEmitted = 0;
                                this.upstream.request((long) i12);
                            }
                        }
                    } catch (Throwable th2) {
                        a.b(th2);
                        this.errors.tryAddThrowableOrReport(th2);
                        drain();
                    }
                } else {
                    int i13 = this.bufferSize;
                    long j11 = this.uniqueId;
                    this.uniqueId = 1 + j11;
                    FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber = new FlowableFlatMap$InnerSubscriber(this, i13, j11);
                    if (addInner(flowableFlatMap$InnerSubscriber)) {
                        bVar.subscribe(flowableFlatMap$InnerSubscriber);
                    }
                }
            } catch (Throwable th3) {
                a.b(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            if (!this.cancelled) {
                int i11 = this.maxConcurrency;
                if (i11 == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request((long) i11);
                }
            }
        }
    }

    public void removeInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<T, U>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (flowableFlatMap$InnerSubscriberArr[i12] == flowableFlatMap$InnerSubscriber) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        flowableFlatMap$InnerSubscriberArr2 = EMPTY;
                    } else {
                        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr3 = new FlowableFlatMap$InnerSubscriber[(length - 1)];
                        System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr3, 0, i11);
                        System.arraycopy(flowableFlatMap$InnerSubscriberArr, i11 + 1, flowableFlatMap$InnerSubscriberArr3, i11, (length - i11) - 1);
                        flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            drain();
        }
    }

    public void tryEmit(U u11, FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        if (get() != 0 || !compareAndSet(0, 1)) {
            f fVar = flowableFlatMap$InnerSubscriber.queue;
            if (fVar == null) {
                fVar = new SpscArrayQueue(this.bufferSize);
                flowableFlatMap$InnerSubscriber.queue = fVar;
            }
            if (!fVar.offer(u11)) {
                onError(new MissingBackpressureException("Inner queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
        } else {
            long j11 = this.requested.get();
            f fVar2 = flowableFlatMap$InnerSubscriber.queue;
            if (j11 == 0 || (fVar2 != null && !fVar2.isEmpty())) {
                if (fVar2 == null) {
                    fVar2 = new SpscArrayQueue(this.bufferSize);
                    flowableFlatMap$InnerSubscriber.queue = fVar2;
                }
                if (!fVar2.offer(u11)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                }
            } else {
                this.downstream.onNext(u11);
                if (j11 != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                flowableFlatMap$InnerSubscriber.requestMore(1);
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        drainLoop();
    }

    public void tryEmitScalar(U u11) {
        if (get() == 0 && compareAndSet(0, 1)) {
            long j11 = this.requested.get();
            f fVar = this.queue;
            if (j11 == 0 || (fVar != null && !fVar.isEmpty())) {
                if (fVar == null) {
                    fVar = getMainQueue();
                }
                if (!fVar.offer(u11)) {
                    onError(new MissingBackpressureException("Scalar queue full?!"));
                }
            } else {
                this.downstream.onNext(u11);
                if (j11 != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                    int i11 = this.scalarEmitted + 1;
                    this.scalarEmitted = i11;
                    int i12 = this.scalarLimit;
                    if (i11 == i12) {
                        this.scalarEmitted = 0;
                        this.upstream.request((long) i12);
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else if (!getMainQueue().offer(u11)) {
            onError(new MissingBackpressureException("Scalar queue full?!"));
            return;
        } else if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }
}
