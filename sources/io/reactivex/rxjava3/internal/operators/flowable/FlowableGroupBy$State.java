package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;

final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements b<T> {
    public static final int ABANDONED = 2;
    public static final int ABANDONED_HAS_SUBSCRIBER = 3;
    public static final int FRESH = 0;
    public static final int HAS_SUBSCRIBER = 1;
    private static final long serialVersionUID = -3852313036005250360L;
    public final AtomicReference<c<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicInteger once = new AtomicInteger();
    public boolean outputFused;
    public final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    public int produced;
    public final a<T> queue;
    public final AtomicLong requested = new AtomicLong();

    public FlowableGroupBy$State(int i11, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k11, boolean z11) {
        this.queue = new a<>(i11);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k11;
        this.delayError = z11;
    }

    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            cancelParent();
            drain();
        }
    }

    public void cancelParent() {
        if ((this.once.get() & 2) == 0) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, c<? super T> cVar, boolean z13, long j11) {
        if (this.cancelled.get()) {
            while (this.queue.poll() != null) {
                j11++;
            }
            if (j11 != 0) {
                requestParent(j11);
            }
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!z13) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    cVar.onError(th2);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    cVar.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                Throwable th3 = this.error;
                if (th3 != null) {
                    cVar.onError(th3);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
    }

    public void clear() {
        a<T> aVar = this.queue;
        while (aVar.poll() != null) {
            this.produced++;
        }
        tryReplenish();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }
    }

    public void drainFused() {
        Throwable th2;
        a<T> aVar = this.queue;
        c cVar = this.actual.get();
        int i11 = 1;
        while (true) {
            if (cVar != null) {
                if (!this.cancelled.get()) {
                    boolean z11 = this.done;
                    if (!z11 || this.delayError || (th2 = this.error) == null) {
                        cVar.onNext(null);
                        if (z11) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                cVar.onError(th3);
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        }
                    } else {
                        aVar.clear();
                        cVar.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            i11 = addAndGet(-i11);
            if (i11 != 0) {
                if (cVar == null) {
                    cVar = this.actual.get();
                }
            } else {
                return;
            }
        }
    }

    public void drainNormal() {
        int i11;
        long j11;
        a<T> aVar = this.queue;
        boolean z11 = this.delayError;
        c cVar = this.actual.get();
        int i12 = 1;
        while (true) {
            if (cVar != null) {
                long j12 = this.requested.get();
                long j13 = 0;
                while (true) {
                    i11 = (j13 > j12 ? 1 : (j13 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.done;
                    T poll = aVar.poll();
                    boolean z13 = poll == null;
                    T t11 = poll;
                    long j14 = j13;
                    if (!checkTerminated(z12, z13, cVar, z11, j13)) {
                        if (z13) {
                            j13 = j14;
                            break;
                        } else {
                            cVar.onNext(t11);
                            j13 = j14 + 1;
                        }
                    } else {
                        return;
                    }
                }
                if (i11 == 0) {
                    j11 = j13;
                    if (checkTerminated(this.done, aVar.isEmpty(), cVar, z11, j13)) {
                        return;
                    }
                } else {
                    j11 = j13;
                }
                if (j11 != 0) {
                    io.reactivex.rxjava3.internal.util.b.e(this.requested, j11);
                    requestParent(j11);
                }
            }
            i12 = addAndGet(-i12);
            if (i12 != 0) {
                if (cVar == null) {
                    cVar = this.actual.get();
                }
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        if (this.queue.isEmpty()) {
            tryReplenish();
            return true;
        }
        tryReplenish();
        return false;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public T poll() {
        T poll = this.queue.poll();
        if (poll != null) {
            this.produced++;
            return poll;
        }
        tryReplenish();
        return null;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            drain();
        }
    }

    public int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    public void requestParent(long j11) {
        if ((this.once.get() & 2) == 0) {
            this.parent.requestGroup(j11);
        }
    }

    public void subscribe(c<? super T> cVar) {
        int i11;
        do {
            i11 = this.once.get();
            if ((i11 & 1) != 0) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), cVar);
                return;
            }
        } while (!this.once.compareAndSet(i11, i11 | 1));
        cVar.onSubscribe(this);
        this.actual.lazySet(cVar);
        if (this.cancelled.get()) {
            this.actual.lazySet((Object) null);
        } else {
            drain();
        }
    }

    public boolean tryAbandon() {
        return this.once.get() == 0 && this.once.compareAndSet(0, 2);
    }

    public void tryReplenish() {
        int i11 = this.produced;
        if (i11 != 0) {
            this.produced = 0;
            requestParent((long) i11);
        }
    }
}
