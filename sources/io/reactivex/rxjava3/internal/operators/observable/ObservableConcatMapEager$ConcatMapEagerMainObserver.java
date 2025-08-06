package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserver;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j00.h;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import k00.f;
import l00.a;

final class ObservableConcatMapEager$ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements k<T>, b, a<R> {
    private static final long serialVersionUID = 8080567949447303262L;
    public int activeCount;
    public volatile boolean cancelled;
    public InnerQueuedObserver<R> current;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends j<? extends R>> mapper;
    public final int maxConcurrency;
    public final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();
    public final int prefetch;
    public f<T> queue;
    public int sourceMode;
    public b upstream;

    public ObservableConcatMapEager$ConcatMapEagerMainObserver(k<? super R> kVar, h<? super T, ? extends j<? extends R>> hVar, int i11, int i12, ErrorMode errorMode2) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.maxConcurrency = i11;
        this.prefetch = i12;
        this.errorMode = errorMode2;
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.dispose();
            this.errors.tryTerminateAndReport();
            drainAndDispose();
        }
    }

    public void disposeAll() {
        InnerQueuedObserver<R> innerQueuedObserver = this.current;
        if (innerQueuedObserver != null) {
            innerQueuedObserver.dispose();
        }
        while (true) {
            InnerQueuedObserver poll = this.observers.poll();
            if (poll != null) {
                poll.dispose();
            } else {
                return;
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            f<T> fVar = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
            k<? super R> kVar = this.downstream;
            ErrorMode errorMode2 = this.errorMode;
            int i11 = 1;
            while (true) {
                int i12 = this.activeCount;
                while (true) {
                    if (i12 == this.maxConcurrency) {
                        break;
                    } else if (this.cancelled) {
                        fVar.clear();
                        disposeAll();
                        return;
                    } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                        try {
                            T poll = fVar.poll();
                            if (poll == null) {
                                break;
                            }
                            Object apply = this.mapper.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            j jVar = (j) apply;
                            InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.prefetch);
                            arrayDeque.offer(innerQueuedObserver);
                            jVar.subscribe(innerQueuedObserver);
                            i12++;
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            this.upstream.dispose();
                            fVar.clear();
                            disposeAll();
                            this.errors.tryAddThrowableOrReport(th2);
                            this.errors.tryTerminateConsumer((k<?>) this.downstream);
                            return;
                        }
                    } else {
                        fVar.clear();
                        disposeAll();
                        this.errors.tryTerminateConsumer((k<?>) this.downstream);
                        return;
                    }
                }
                this.activeCount = i12;
                if (this.cancelled) {
                    fVar.clear();
                    disposeAll();
                    return;
                } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                    InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                    if (innerQueuedObserver2 == null) {
                        if (errorMode2 != ErrorMode.BOUNDARY || ((Throwable) this.errors.get()) == null) {
                            boolean z11 = this.done;
                            InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                            boolean z12 = poll2 == null;
                            if (!z11 || !z12) {
                                if (!z12) {
                                    this.current = poll2;
                                }
                                innerQueuedObserver2 = poll2;
                            } else if (((Throwable) this.errors.get()) != null) {
                                fVar.clear();
                                disposeAll();
                                this.errors.tryTerminateConsumer((k<?>) kVar);
                                return;
                            } else {
                                kVar.onComplete();
                                return;
                            }
                        } else {
                            fVar.clear();
                            disposeAll();
                            this.errors.tryTerminateConsumer((k<?>) kVar);
                            return;
                        }
                    }
                    if (innerQueuedObserver2 != null) {
                        f<R> queue2 = innerQueuedObserver2.queue();
                        while (!this.cancelled) {
                            boolean isDone = innerQueuedObserver2.isDone();
                            if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                try {
                                    R poll3 = queue2.poll();
                                    boolean z13 = poll3 == null;
                                    if (isDone && z13) {
                                        this.current = null;
                                        this.activeCount--;
                                    } else if (!z13) {
                                        kVar.onNext(poll3);
                                    }
                                } catch (Throwable th3) {
                                    io.reactivex.rxjava3.exceptions.a.b(th3);
                                    this.errors.tryAddThrowableOrReport(th3);
                                    this.current = null;
                                    this.activeCount--;
                                }
                            } else {
                                fVar.clear();
                                disposeAll();
                                this.errors.tryTerminateConsumer((k<?>) kVar);
                                return;
                            }
                        }
                        fVar.clear();
                        disposeAll();
                        return;
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    fVar.clear();
                    disposeAll();
                    this.errors.tryTerminateConsumer((k<?>) this.downstream);
                    return;
                }
            }
        }
    }

    public void drainAndDispose() {
        if (getAndIncrement() == 0) {
            do {
                this.queue.clear();
                disposeAll();
            } while (decrementAndGet() != 0);
        }
    }

    public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
        innerQueuedObserver.setDone();
        drain();
    }

    public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }
    }

    public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r11) {
        innerQueuedObserver.queue().offer(r11);
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
            this.queue = new io.reactivex.rxjava3.internal.queue.a(this.prefetch);
            this.downstream.onSubscribe(this);
        }
    }
}
