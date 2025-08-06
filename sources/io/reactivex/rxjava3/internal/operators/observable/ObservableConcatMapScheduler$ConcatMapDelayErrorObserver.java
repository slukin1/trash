package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;

final class ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements k<T>, b, Runnable {
    private static final long serialVersionUID = -6951100001833242599L;
    public volatile boolean active;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends j<? extends R>> mapper;
    public final DelayErrorInnerObserver<R> observer;
    public f<T> queue;
    public int sourceMode;
    public final boolean tillTheEnd;
    public b upstream;
    public final Scheduler.Worker worker;

    public static final class DelayErrorInnerObserver<R> extends AtomicReference<b> implements k<R> {
        private static final long serialVersionUID = 2620149119579502636L;
        public final k<? super R> downstream;
        public final ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> parent;

        public DelayErrorInnerObserver(k<? super R> kVar, ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> observableConcatMapScheduler$ConcatMapDelayErrorObserver) {
            this.downstream = kVar;
            this.parent = observableConcatMapScheduler$ConcatMapDelayErrorObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> observableConcatMapScheduler$ConcatMapDelayErrorObserver = this.parent;
            observableConcatMapScheduler$ConcatMapDelayErrorObserver.active = false;
            observableConcatMapScheduler$ConcatMapDelayErrorObserver.drain();
        }

        public void onError(Throwable th2) {
            ObservableConcatMapScheduler$ConcatMapDelayErrorObserver<?, R> observableConcatMapScheduler$ConcatMapDelayErrorObserver = this.parent;
            if (observableConcatMapScheduler$ConcatMapDelayErrorObserver.errors.tryAddThrowableOrReport(th2)) {
                if (!observableConcatMapScheduler$ConcatMapDelayErrorObserver.tillTheEnd) {
                    observableConcatMapScheduler$ConcatMapDelayErrorObserver.upstream.dispose();
                }
                observableConcatMapScheduler$ConcatMapDelayErrorObserver.active = false;
                observableConcatMapScheduler$ConcatMapDelayErrorObserver.drain();
            }
        }

        public void onNext(R r11) {
            this.downstream.onNext(r11);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMapScheduler$ConcatMapDelayErrorObserver(k<? super R> kVar, h<? super T, ? extends j<? extends R>> hVar, int i11, boolean z11, Scheduler.Worker worker2) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.bufferSize = i11;
        this.tillTheEnd = z11;
        this.observer = new DelayErrorInnerObserver<>(kVar, this);
        this.worker = worker2;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
        this.worker.dispose();
        this.errors.tryTerminateAndReport();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
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
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        if (this.sourceMode == 0) {
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
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            this.queue = new a(this.bufferSize);
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        k<? super R> kVar = this.downstream;
        f<T> fVar = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        while (true) {
            if (!this.active) {
                if (this.cancelled) {
                    fVar.clear();
                    return;
                } else if (this.tillTheEnd || ((Throwable) atomicThrowable.get()) == null) {
                    boolean z11 = this.done;
                    try {
                        T poll = fVar.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            this.cancelled = true;
                            atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                            this.worker.dispose();
                            return;
                        } else if (!z12) {
                            try {
                                Object apply = this.mapper.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                j jVar = (j) apply;
                                if (jVar instanceof j00.k) {
                                    try {
                                        Object obj = ((j00.k) jVar).get();
                                        if (obj != null && !this.cancelled) {
                                            kVar.onNext(obj);
                                        }
                                    } catch (Throwable th2) {
                                        io.reactivex.rxjava3.exceptions.a.b(th2);
                                        atomicThrowable.tryAddThrowableOrReport(th2);
                                    }
                                } else {
                                    this.active = true;
                                    jVar.subscribe(this.observer);
                                }
                            } catch (Throwable th3) {
                                io.reactivex.rxjava3.exceptions.a.b(th3);
                                this.cancelled = true;
                                this.upstream.dispose();
                                fVar.clear();
                                atomicThrowable.tryAddThrowableOrReport(th3);
                                atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                                this.worker.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        io.reactivex.rxjava3.exceptions.a.b(th4);
                        this.cancelled = true;
                        this.upstream.dispose();
                        atomicThrowable.tryAddThrowableOrReport(th4);
                        atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                        this.worker.dispose();
                        return;
                    }
                } else {
                    fVar.clear();
                    this.cancelled = true;
                    atomicThrowable.tryTerminateConsumer((k<?>) kVar);
                    this.worker.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }
}
