package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import h00.m;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableMergeWithSingle$MergeWithObserver<T> extends AtomicInteger implements e<T>, d {
    public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    public static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    public volatile boolean cancelled;
    public int consumed;
    public final c<? super T> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final int limit;
    public volatile boolean mainDone;
    public final AtomicReference<d> mainSubscription = new AtomicReference<>();
    public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
    public volatile int otherState;
    public final int prefetch;
    public volatile k00.e<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public T singleItem;

    public static final class OtherObserver<T> extends AtomicReference<b> implements m<T> {
        private static final long serialVersionUID = -2935427570954647017L;
        public final FlowableMergeWithSingle$MergeWithObserver<T> parent;

        public OtherObserver(FlowableMergeWithSingle$MergeWithObserver<T> flowableMergeWithSingle$MergeWithObserver) {
            this.parent = flowableMergeWithSingle$MergeWithObserver;
        }

        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(T t11) {
            this.parent.otherSuccess(t11);
        }
    }

    public FlowableMergeWithSingle$MergeWithObserver(c<? super T> cVar) {
        this.downstream = cVar;
        int b11 = Flowable.b();
        this.prefetch = b11;
        this.limit = b11 - (b11 >> 2);
    }

    public void cancel() {
        this.cancelled = true;
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue = null;
            this.singleItem = null;
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        int i11;
        c<? super T> cVar = this.downstream;
        long j11 = this.emitted;
        int i12 = this.consumed;
        int i13 = this.limit;
        int i14 = 1;
        int i15 = 1;
        while (true) {
            long j12 = this.requested.get();
            while (true) {
                i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                if (i11 == 0) {
                    break;
                } else if (this.cancelled) {
                    this.singleItem = null;
                    this.queue = null;
                    return;
                } else if (this.errors.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    return;
                } else {
                    int i16 = this.otherState;
                    if (i16 == i14) {
                        T t11 = this.singleItem;
                        this.singleItem = null;
                        this.otherState = 2;
                        cVar.onNext(t11);
                        j11++;
                    } else {
                        boolean z11 = this.mainDone;
                        k00.e<T> eVar = this.queue;
                        T poll = eVar != null ? eVar.poll() : null;
                        boolean z12 = poll == null;
                        if (z11 && z12 && i16 == 2) {
                            this.queue = null;
                            cVar.onComplete();
                            return;
                        } else if (z12) {
                            break;
                        } else {
                            cVar.onNext(poll);
                            j11++;
                            i12++;
                            if (i12 == i13) {
                                this.mainSubscription.get().request((long) i13);
                                i12 = 0;
                            }
                            i14 = 1;
                        }
                    }
                }
            }
            if (i11 == 0) {
                if (this.cancelled) {
                    this.singleItem = null;
                    this.queue = null;
                    return;
                } else if (this.errors.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    return;
                } else {
                    boolean z13 = this.mainDone;
                    k00.e<T> eVar2 = this.queue;
                    boolean z14 = eVar2 == null || eVar2.isEmpty();
                    if (z13 && z14 && this.otherState == 2) {
                        this.queue = null;
                        cVar.onComplete();
                        return;
                    }
                }
            }
            this.emitted = j11;
            this.consumed = i12;
            i15 = addAndGet(-i15);
            if (i15 != 0) {
                i14 = 1;
            } else {
                return;
            }
        }
    }

    public k00.e<T> getOrCreateQueue() {
        k00.e<T> eVar = this.queue;
        if (eVar != null) {
            return eVar;
        }
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.b());
        this.queue = spscArrayQueue;
        return spscArrayQueue;
    }

    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            DisposableHelper.dispose(this.otherObserver);
            drain();
        }
    }

    public void onNext(T t11) {
        if (compareAndSet(0, 1)) {
            long j11 = this.emitted;
            if (this.requested.get() != j11) {
                k00.e<T> eVar = this.queue;
                if (eVar == null || eVar.isEmpty()) {
                    this.emitted = j11 + 1;
                    this.downstream.onNext(t11);
                    int i11 = this.consumed + 1;
                    if (i11 == this.limit) {
                        this.consumed = 0;
                        this.mainSubscription.get().request((long) i11);
                    } else {
                        this.consumed = i11;
                    }
                } else {
                    eVar.offer(t11);
                }
            } else {
                getOrCreateQueue().offer(t11);
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            getOrCreateQueue().offer(t11);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this.mainSubscription, dVar, (long) this.prefetch);
    }

    public void otherError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            SubscriptionHelper.cancel(this.mainSubscription);
            drain();
        }
    }

    public void otherSuccess(T t11) {
        if (compareAndSet(0, 1)) {
            long j11 = this.emitted;
            if (this.requested.get() != j11) {
                this.emitted = j11 + 1;
                this.downstream.onNext(t11);
                this.otherState = 2;
            } else {
                this.singleItem = t11;
                this.otherState = 1;
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            this.singleItem = t11;
            this.otherState = 1;
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public void request(long j11) {
        io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        drain();
    }
}
