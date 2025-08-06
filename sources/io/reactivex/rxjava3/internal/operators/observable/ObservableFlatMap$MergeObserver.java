package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.e;
import k00.f;

final class ObservableFlatMap$MergeObserver<T, U> extends AtomicInteger implements b, k<T> {
    public static final ObservableFlatMap$InnerObserver<?, ?>[] CANCELLED = new ObservableFlatMap$InnerObserver[0];
    public static final ObservableFlatMap$InnerObserver<?, ?>[] EMPTY = new ObservableFlatMap$InnerObserver[0];
    private static final long serialVersionUID = -2117620485640801370L;
    public final int bufferSize;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public volatile boolean done;
    public final k<? super U> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public int lastIndex;
    public final h<? super T, ? extends j<? extends U>> mapper;
    public final int maxConcurrency;
    public final AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> observers;
    public volatile e<U> queue;
    public Queue<j<? extends U>> sources;
    public long uniqueId;
    public b upstream;
    public int wip;

    public ObservableFlatMap$MergeObserver(k<? super U> kVar, h<? super T, ? extends j<? extends U>> hVar, boolean z11, int i11, int i12) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.delayErrors = z11;
        this.maxConcurrency = i11;
        this.bufferSize = i12;
        if (i11 != Integer.MAX_VALUE) {
            this.sources = new ArrayDeque(i11);
        }
        this.observers = new AtomicReference<>(EMPTY);
    }

    public boolean addInner(ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr;
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArr2;
        do {
            observableFlatMap$InnerObserverArr = (ObservableFlatMap$InnerObserver[]) this.observers.get();
            if (observableFlatMap$InnerObserverArr == CANCELLED) {
                observableFlatMap$InnerObserver.dispose();
                return false;
            }
            int length = observableFlatMap$InnerObserverArr.length;
            observableFlatMap$InnerObserverArr2 = new ObservableFlatMap$InnerObserver[(length + 1)];
            System.arraycopy(observableFlatMap$InnerObserverArr, 0, observableFlatMap$InnerObserverArr2, 0, length);
            observableFlatMap$InnerObserverArr2[length] = observableFlatMap$InnerObserver;
        } while (!this.observers.compareAndSet(observableFlatMap$InnerObserverArr, observableFlatMap$InnerObserverArr2));
        return true;
    }

    public boolean checkTerminate() {
        if (this.disposed) {
            return true;
        }
        Throwable th2 = (Throwable) this.errors.get();
        if (this.delayErrors || th2 == null) {
            return false;
        }
        disposeAll();
        this.errors.tryTerminateConsumer((k<?>) this.downstream);
        return true;
    }

    public void dispose() {
        this.disposed = true;
        if (disposeAll()) {
            this.errors.tryTerminateAndReport();
        }
    }

    public boolean disposeAll() {
        this.upstream.dispose();
        AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> atomicReference = this.observers;
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr = CANCELLED;
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr2 = (ObservableFlatMap$InnerObserver[]) atomicReference.getAndSet(observableFlatMap$InnerObserverArr);
        if (observableFlatMap$InnerObserverArr2 == observableFlatMap$InnerObserverArr) {
            return false;
        }
        for (ObservableFlatMap$InnerObserver<?, ?> dispose : observableFlatMap$InnerObserverArr2) {
            dispose.dispose();
        }
        return true;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        int i11;
        k<? super U> kVar = this.downstream;
        int i12 = 1;
        while (!checkTerminate()) {
            e<U> eVar = this.queue;
            int i13 = 0;
            if (eVar != null) {
                while (!checkTerminate()) {
                    U poll = eVar.poll();
                    if (poll != null) {
                        kVar.onNext(poll);
                        i13++;
                    }
                }
                return;
            }
            if (i13 == 0) {
                boolean z11 = this.done;
                e<U> eVar2 = this.queue;
                ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArr = (ObservableFlatMap$InnerObserver[]) this.observers.get();
                int length = observableFlatMap$InnerObserverArr.length;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i11 = this.sources.size();
                    }
                } else {
                    i11 = 0;
                }
                if (!z11 || !((eVar2 == null || eVar2.isEmpty()) && length == 0 && i11 == 0)) {
                    if (length != 0) {
                        int min = Math.min(length - 1, this.lastIndex);
                        int i14 = 0;
                        while (i14 < length) {
                            if (!checkTerminate()) {
                                ObservableFlatMap$InnerObserver observableFlatMap$InnerObserver = observableFlatMap$InnerObserverArr[min];
                                f<U> fVar = observableFlatMap$InnerObserver.queue;
                                if (fVar != null) {
                                    while (true) {
                                        try {
                                            U poll2 = fVar.poll();
                                            if (poll2 == null) {
                                                break;
                                            }
                                            kVar.onNext(poll2);
                                            if (checkTerminate()) {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            a.b(th2);
                                            observableFlatMap$InnerObserver.dispose();
                                            this.errors.tryAddThrowableOrReport(th2);
                                            if (!checkTerminate()) {
                                                removeInner(observableFlatMap$InnerObserver);
                                                i13++;
                                                min++;
                                                if (min != length) {
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                boolean z12 = observableFlatMap$InnerObserver.done;
                                f<U> fVar2 = observableFlatMap$InnerObserver.queue;
                                if (z12 && (fVar2 == null || fVar2.isEmpty())) {
                                    removeInner(observableFlatMap$InnerObserver);
                                    i13++;
                                }
                                min++;
                                if (min != length) {
                                    i14++;
                                }
                                min = 0;
                                i14++;
                            } else {
                                return;
                            }
                        }
                        this.lastIndex = min;
                    }
                    if (i13 == 0) {
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                        subscribeMore(i13);
                    }
                } else {
                    this.errors.tryTerminateConsumer((k<?>) this.downstream);
                    return;
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                subscribeMore(i13);
            }
        }
    }

    public boolean isDisposed() {
        return this.disposed;
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
            drain();
        }
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                Object apply = this.mapper.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                j jVar = (j) apply;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i11 = this.wip;
                        if (i11 == this.maxConcurrency) {
                            this.sources.offer(jVar);
                            return;
                        }
                        this.wip = i11 + 1;
                    }
                }
                subscribeInner(jVar);
            } catch (Throwable th2) {
                a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void removeInner(ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver<T, U>[] observableFlatMap$InnerObserverArr;
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr2;
        do {
            observableFlatMap$InnerObserverArr = (ObservableFlatMap$InnerObserver[]) this.observers.get();
            int length = observableFlatMap$InnerObserverArr.length;
            int i11 = -1;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                } else if (observableFlatMap$InnerObserverArr[i12] == observableFlatMap$InnerObserver) {
                    i11 = i12;
                    break;
                } else {
                    i12++;
                }
            }
            if (i11 >= 0) {
                if (length == 1) {
                    observableFlatMap$InnerObserverArr2 = EMPTY;
                } else {
                    ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr3 = new ObservableFlatMap$InnerObserver[(length - 1)];
                    System.arraycopy(observableFlatMap$InnerObserverArr, 0, observableFlatMap$InnerObserverArr3, 0, i11);
                    System.arraycopy(observableFlatMap$InnerObserverArr, i11 + 1, observableFlatMap$InnerObserverArr3, i11, (length - i11) - 1);
                    observableFlatMap$InnerObserverArr2 = observableFlatMap$InnerObserverArr3;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(observableFlatMap$InnerObserverArr, observableFlatMap$InnerObserverArr2));
    }

    public void subscribeInner(j<? extends U> jVar) {
        j<? extends U> poll;
        while (jVar instanceof j00.k) {
            if (tryEmitScalar((j00.k) jVar) && this.maxConcurrency != Integer.MAX_VALUE) {
                boolean z11 = false;
                synchronized (this) {
                    poll = this.sources.poll();
                    if (poll == null) {
                        this.wip--;
                        z11 = true;
                    }
                }
                if (z11) {
                    drain();
                    return;
                }
                jVar = poll;
            } else {
                return;
            }
        }
        long j11 = this.uniqueId;
        this.uniqueId = 1 + j11;
        ObservableFlatMap$InnerObserver observableFlatMap$InnerObserver = new ObservableFlatMap$InnerObserver(this, j11);
        if (addInner(observableFlatMap$InnerObserver)) {
            jVar.subscribe(observableFlatMap$InnerObserver);
        }
    }

    public void subscribeMore(int i11) {
        while (true) {
            int i12 = i11 - 1;
            if (i11 != 0) {
                synchronized (this) {
                    j poll = this.sources.poll();
                    if (poll == null) {
                        this.wip--;
                    } else {
                        subscribeInner(poll);
                    }
                }
                i11 = i12;
            } else {
                return;
            }
        }
        while (true) {
        }
    }

    public void tryEmit(U u11, ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        if (get() != 0 || !compareAndSet(0, 1)) {
            f fVar = observableFlatMap$InnerObserver.queue;
            if (fVar == null) {
                fVar = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
                observableFlatMap$InnerObserver.queue = fVar;
            }
            fVar.offer(u11);
            if (getAndIncrement() != 0) {
                return;
            }
        } else {
            this.downstream.onNext(u11);
            if (decrementAndGet() == 0) {
                return;
            }
        }
        drainLoop();
    }

    public boolean tryEmitScalar(j00.k<? extends U> kVar) {
        try {
            Object obj = kVar.get();
            if (obj == null) {
                return true;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                e<U> eVar = this.queue;
                if (eVar == null) {
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        eVar = new io.reactivex.rxjava3.internal.queue.a<>(this.bufferSize);
                    } else {
                        eVar = new SpscArrayQueue<>(this.maxConcurrency);
                    }
                    this.queue = eVar;
                }
                eVar.offer(obj);
                if (getAndIncrement() != 0) {
                    return false;
                }
            } else {
                this.downstream.onNext(obj);
                if (decrementAndGet() == 0) {
                    return true;
                }
            }
            drainLoop();
            return true;
        } catch (Throwable th2) {
            a.b(th2);
            this.errors.tryAddThrowableOrReport(th2);
            drain();
            return true;
        }
    }
}
