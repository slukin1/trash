package io.reactivex.rxjava3.internal.operators.flowable;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;
import k00.f;

final class FlowableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements b, m {
    private static final long serialVersionUID = -6178010334400373240L;
    public final d<? super T, ? super T> comparer;
    public final m<? super Boolean> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;

    /* renamed from: v1  reason: collision with root package name */
    public T f55494v1;

    /* renamed from: v2  reason: collision with root package name */
    public T f55495v2;

    public FlowableSequenceEqualSingle$EqualCoordinator(m<? super Boolean> mVar, int i11, d<? super T, ? super T> dVar) {
        this.downstream = mVar;
        this.comparer = dVar;
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i11);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i11);
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    public void dispose() {
        this.first.cancel();
        this.second.cancel();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            int i11 = 1;
            do {
                f<T> fVar = this.first.queue;
                f<T> fVar2 = this.second.queue;
                if (fVar != null && fVar2 != null) {
                    while (!isDisposed()) {
                        if (((Throwable) this.errors.get()) != null) {
                            cancelAndClear();
                            this.errors.tryTerminateConsumer((m<?>) this.downstream);
                            return;
                        }
                        boolean z11 = this.first.done;
                        T t11 = this.f55494v1;
                        if (t11 == null) {
                            try {
                                t11 = fVar.poll();
                                this.f55494v1 = t11;
                            } catch (Throwable th2) {
                                a.b(th2);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(th2);
                                this.errors.tryTerminateConsumer((m<?>) this.downstream);
                                return;
                            }
                        }
                        boolean z12 = false;
                        boolean z13 = t11 == null;
                        boolean z14 = this.second.done;
                        T t12 = this.f55495v2;
                        if (t12 == null) {
                            try {
                                t12 = fVar2.poll();
                                this.f55495v2 = t12;
                            } catch (Throwable th3) {
                                a.b(th3);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(th3);
                                this.errors.tryTerminateConsumer((m<?>) this.downstream);
                                return;
                            }
                        }
                        if (t12 == null) {
                            z12 = true;
                        }
                        if (z11 && z14 && z13 && z12) {
                            this.downstream.onSuccess(Boolean.TRUE);
                            return;
                        } else if (z11 && z14 && z13 != z12) {
                            cancelAndClear();
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        } else if (!z13 && !z12) {
                            try {
                                if (!this.comparer.a(t11, t12)) {
                                    cancelAndClear();
                                    this.downstream.onSuccess(Boolean.FALSE);
                                    return;
                                }
                                this.f55494v1 = null;
                                this.f55495v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable th4) {
                                a.b(th4);
                                cancelAndClear();
                                this.errors.tryAddThrowableOrReport(th4);
                                this.errors.tryTerminateConsumer((m<?>) this.downstream);
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (((Throwable) this.errors.get()) != null) {
                    cancelAndClear();
                    this.errors.tryTerminateConsumer((m<?>) this.downstream);
                    return;
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            drain();
        }
    }

    public boolean isDisposed() {
        return this.first.get() == SubscriptionHelper.CANCELLED;
    }

    public void subscribe(z20.b<? extends T> bVar, z20.b<? extends T> bVar2) {
        bVar.subscribe(this.first);
        bVar2.subscribe(this.second);
    }
}
