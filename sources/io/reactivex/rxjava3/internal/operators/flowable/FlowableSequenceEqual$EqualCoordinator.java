package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;
import k00.f;
import z20.b;
import z20.c;

final class FlowableSequenceEqual$EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements m {
    private static final long serialVersionUID = -6178010334400373240L;
    public final d<? super T, ? super T> comparer;
    public final AtomicThrowable errors;
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;

    /* renamed from: v1  reason: collision with root package name */
    public T f55492v1;

    /* renamed from: v2  reason: collision with root package name */
    public T f55493v2;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableSequenceEqual$EqualCoordinator(c<? super Boolean> cVar, int i11, d<? super T, ? super T> dVar) {
        super(cVar);
        this.comparer = dVar;
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i11);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i11);
        this.errors = new AtomicThrowable();
    }

    public void cancel() {
        super.cancel();
        this.first.cancel();
        this.second.cancel();
        this.errors.tryTerminateAndReport();
        if (this.wip.getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            int i11 = 1;
            do {
                f<T> fVar = this.first.queue;
                f<T> fVar2 = this.second.queue;
                if (fVar != null && fVar2 != null) {
                    while (!isCancelled()) {
                        if (((Throwable) this.errors.get()) != null) {
                            cancelAndClear();
                            this.errors.tryTerminateConsumer((c<?>) this.downstream);
                            return;
                        }
                        boolean z11 = this.first.done;
                        T t11 = this.f55492v1;
                        if (t11 == null) {
                            try {
                                t11 = fVar.poll();
                                this.f55492v1 = t11;
                            } catch (Throwable th2) {
                                a.b(th2);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(th2);
                                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                                return;
                            }
                        }
                        boolean z12 = false;
                        boolean z13 = t11 == null;
                        boolean z14 = this.second.done;
                        T t12 = this.f55493v2;
                        if (t12 == null) {
                            try {
                                t12 = fVar2.poll();
                                this.f55493v2 = t12;
                            } catch (Throwable th3) {
                                a.b(th3);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(th3);
                                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                                return;
                            }
                        }
                        if (t12 == null) {
                            z12 = true;
                        }
                        if (z11 && z14 && z13 && z12) {
                            complete(Boolean.TRUE);
                            return;
                        } else if (z11 && z14 && z13 != z12) {
                            cancelAndClear();
                            complete(Boolean.FALSE);
                            return;
                        } else if (!z13 && !z12) {
                            try {
                                if (!this.comparer.a(t11, t12)) {
                                    cancelAndClear();
                                    complete(Boolean.FALSE);
                                    return;
                                }
                                this.f55492v1 = null;
                                this.f55493v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable th4) {
                                a.b(th4);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(th4);
                                this.errors.tryTerminateConsumer((c<?>) this.downstream);
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isCancelled()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (((Throwable) this.errors.get()) != null) {
                    cancelAndClear();
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    return;
                }
                i11 = this.wip.addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            drain();
        }
    }

    public void subscribe(b<? extends T> bVar, b<? extends T> bVar2) {
        bVar.subscribe(this.first);
        bVar2.subscribe(this.second);
    }
}
