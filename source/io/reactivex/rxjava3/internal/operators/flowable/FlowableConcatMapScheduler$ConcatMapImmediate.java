package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.a;
import j00.h;
import j00.k;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;

final class FlowableConcatMapScheduler$ConcatMapImmediate<T, R> extends FlowableConcatMapScheduler$BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = 7898995095634264146L;
    public final c<? super R> downstream;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatMapScheduler$ConcatMapImmediate(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i11, Scheduler.Worker worker) {
        super(hVar, i11, worker);
        this.downstream = cVar;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
            this.worker.dispose();
            this.errors.tryTerminateAndReport();
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                this.worker.dispose();
            }
        }
    }

    public void innerNext(R r11) {
        if (tryEnter()) {
            this.downstream.onNext(r11);
            if (!compareAndSet(1, 0)) {
                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                this.worker.dispose();
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                this.worker.dispose();
            }
        }
    }

    public void request(long j11) {
        this.inner.request(j11);
    }

    public void run() {
        while (!this.cancelled) {
            if (!this.active) {
                boolean z11 = this.done;
                try {
                    T poll = this.queue.poll();
                    boolean z12 = poll == null;
                    if (z11 && z12) {
                        this.downstream.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (!z12) {
                        try {
                            Object apply = this.mapper.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                            b bVar = (b) apply;
                            if (this.sourceMode != 1) {
                                int i11 = this.consumed + 1;
                                if (i11 == this.limit) {
                                    this.consumed = 0;
                                    this.upstream.request((long) i11);
                                } else {
                                    this.consumed = i11;
                                }
                            }
                            if (bVar instanceof k) {
                                try {
                                    Object obj = ((k) bVar).get();
                                    if (obj != null && !this.cancelled) {
                                        if (!this.inner.isUnbounded()) {
                                            this.active = true;
                                            FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                            flowableConcatMap$ConcatMapInner.setSubscription(new d(obj, flowableConcatMap$ConcatMapInner));
                                        } else if (tryEnter()) {
                                            this.downstream.onNext(obj);
                                            if (!compareAndSet(1, 0)) {
                                                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                                                this.worker.dispose();
                                                return;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    a.b(th2);
                                    this.upstream.cancel();
                                    this.errors.tryAddThrowableOrReport(th2);
                                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                                    this.worker.dispose();
                                    return;
                                }
                            } else {
                                this.active = true;
                                bVar.subscribe(this.inner);
                            }
                        } catch (Throwable th3) {
                            a.b(th3);
                            this.upstream.cancel();
                            this.errors.tryAddThrowableOrReport(th3);
                            this.errors.tryTerminateConsumer((c<?>) this.downstream);
                            this.worker.dispose();
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    a.b(th4);
                    this.upstream.cancel();
                    this.errors.tryAddThrowableOrReport(th4);
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    this.worker.dispose();
                    return;
                }
            }
            if (this.wip.decrementAndGet() == 0) {
                return;
            }
        }
    }

    public void schedule() {
        if (this.wip.getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }

    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }

    public boolean tryEnter() {
        return get() == 0 && compareAndSet(0, 1);
    }
}
