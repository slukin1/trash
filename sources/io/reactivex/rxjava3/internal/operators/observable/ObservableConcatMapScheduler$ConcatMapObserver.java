package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import o00.a;

final class ObservableConcatMapScheduler$ConcatMapObserver<T, U> extends AtomicInteger implements k<T>, b, Runnable {
    private static final long serialVersionUID = 8828587559905699186L;
    public volatile boolean active;
    public final int bufferSize;
    public volatile boolean disposed;
    public volatile boolean done;
    public final k<? super U> downstream;
    public int fusionMode;
    public final InnerObserver<U> inner;
    public final h<? super T, ? extends j<? extends U>> mapper;
    public f<T> queue;
    public b upstream;
    public final Scheduler.Worker worker;

    public static final class InnerObserver<U> extends AtomicReference<b> implements k<U> {
        private static final long serialVersionUID = -7449079488798789337L;
        public final k<? super U> downstream;
        public final ObservableConcatMapScheduler$ConcatMapObserver<?, ?> parent;

        public InnerObserver(k<? super U> kVar, ObservableConcatMapScheduler$ConcatMapObserver<?, ?> observableConcatMapScheduler$ConcatMapObserver) {
            this.downstream = kVar;
            this.parent = observableConcatMapScheduler$ConcatMapObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.innerComplete();
        }

        public void onError(Throwable th2) {
            this.parent.dispose();
            this.downstream.onError(th2);
        }

        public void onNext(U u11) {
            this.downstream.onNext(u11);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMapScheduler$ConcatMapObserver(k<? super U> kVar, h<? super T, ? extends j<? extends U>> hVar, int i11, Scheduler.Worker worker2) {
        this.downstream = kVar;
        this.mapper = hVar;
        this.bufferSize = i11;
        this.inner = new InnerObserver<>(kVar, this);
        this.worker = worker2;
    }

    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }

    public void innerComplete() {
        this.active = false;
        drain();
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
            a.n(th2);
            return;
        }
        this.done = true;
        dispose();
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            if (this.fusionMode == 0) {
                this.queue.offer(t11);
            }
            drain();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof k00.b) {
                k00.b bVar2 = (k00.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        while (!this.disposed) {
            if (!this.active) {
                boolean z11 = this.done;
                try {
                    T poll = this.queue.poll();
                    boolean z12 = poll == null;
                    if (z11 && z12) {
                        this.disposed = true;
                        this.downstream.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (!z12) {
                        try {
                            Object apply = this.mapper.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            j jVar = (j) apply;
                            this.active = true;
                            jVar.subscribe(this.inner);
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            dispose();
                            this.queue.clear();
                            this.downstream.onError(th2);
                            this.worker.dispose();
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    dispose();
                    this.queue.clear();
                    this.downstream.onError(th3);
                    this.worker.dispose();
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.queue.clear();
    }
}
