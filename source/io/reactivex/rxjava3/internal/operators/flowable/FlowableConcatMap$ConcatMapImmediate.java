package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.util.e;
import j00.h;
import j00.k;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;

final class FlowableConcatMap$ConcatMapImmediate<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = 7898995095634264146L;
    public final c<? super R> downstream;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatMap$ConcatMapImmediate(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i11) {
        super(hVar, i11);
        this.downstream = cVar;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
            this.errors.tryTerminateAndReport();
        }
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean z11 = this.done;
                    try {
                        T poll = this.queue.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            this.downstream.onComplete();
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
                                        if (obj == null) {
                                            continue;
                                        } else if (!this.inner.isUnbounded()) {
                                            this.active = true;
                                            FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                            flowableConcatMap$ConcatMapInner.setSubscription(new d(obj, flowableConcatMap$ConcatMapInner));
                                        } else if (!e.f(this.downstream, obj, this, this.errors)) {
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        a.b(th2);
                                        this.upstream.cancel();
                                        this.errors.tryAddThrowableOrReport(th2);
                                        this.errors.tryTerminateConsumer((c<?>) this.downstream);
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
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        a.b(th4);
                        this.upstream.cancel();
                        this.errors.tryAddThrowableOrReport(th4);
                        this.errors.tryTerminateConsumer((c<?>) this.downstream);
                        return;
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void innerError(Throwable th2) {
        this.upstream.cancel();
        e.d(this.downstream, th2, this, this.errors);
    }

    public void innerNext(R r11) {
        e.f(this.downstream, r11, this, this.errors);
    }

    public void onError(Throwable th2) {
        this.inner.cancel();
        e.d(this.downstream, th2, this, this.errors);
    }

    public void request(long j11) {
        this.inner.request(j11);
    }

    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}
