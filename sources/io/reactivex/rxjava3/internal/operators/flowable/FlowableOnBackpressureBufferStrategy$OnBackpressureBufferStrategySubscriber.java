package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = 3240706908776709697L;
    public final long bufferSize;
    public volatile boolean cancelled;
    public final Deque<T> deque = new ArrayDeque();
    public volatile boolean done;
    public final c<? super T> downstream;
    public Throwable error;
    public final a onOverflow;
    public final AtomicLong requested = new AtomicLong();
    public final BackpressureOverflowStrategy strategy;
    public d upstream;

    public FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(c<? super T> cVar, a aVar, BackpressureOverflowStrategy backpressureOverflowStrategy, long j11) {
        this.downstream = cVar;
        this.onOverflow = aVar;
        this.strategy = backpressureOverflowStrategy;
        this.bufferSize = j11;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() == 0) {
            clear(this.deque);
        }
    }

    public void clear(Deque<T> deque2) {
        synchronized (deque2) {
            deque2.clear();
        }
    }

    public void drain() {
        int i11;
        boolean isEmpty;
        T poll;
        if (getAndIncrement() == 0) {
            Deque<T> deque2 = this.deque;
            c<? super T> cVar = this.downstream;
            int i12 = 1;
            do {
                long j11 = this.requested.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.cancelled) {
                        clear(deque2);
                        return;
                    } else {
                        boolean z11 = this.done;
                        synchronized (deque2) {
                            poll = deque2.poll();
                        }
                        boolean z12 = poll == null;
                        if (z11) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                clear(deque2);
                                cVar.onError(th2);
                                return;
                            } else if (z12) {
                                cVar.onComplete();
                                return;
                            }
                        }
                        if (z12) {
                            break;
                        }
                        cVar.onNext(poll);
                        j12++;
                    }
                }
                if (i11 == 0) {
                    if (this.cancelled) {
                        clear(deque2);
                        return;
                    }
                    boolean z13 = this.done;
                    synchronized (deque2) {
                        isEmpty = deque2.isEmpty();
                    }
                    if (z13) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            clear(deque2);
                            cVar.onError(th3);
                            return;
                        } else if (isEmpty) {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                if (j12 != 0) {
                    b.e(this.requested, j12);
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        boolean z11;
        boolean z12;
        if (!this.done) {
            Deque<T> deque2 = this.deque;
            synchronized (deque2) {
                z11 = false;
                z12 = true;
                if (((long) deque2.size()) == this.bufferSize) {
                    int i11 = i.f55520a[this.strategy.ordinal()];
                    if (i11 == 1) {
                        deque2.pollLast();
                        deque2.offer(t11);
                    } else if (i11 == 2) {
                        deque2.poll();
                        deque2.offer(t11);
                    }
                    z12 = false;
                    z11 = true;
                } else {
                    deque2.offer(t11);
                    z12 = false;
                }
            }
            if (z11) {
                a aVar = this.onOverflow;
                if (aVar != null) {
                    try {
                        aVar.run();
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        this.upstream.cancel();
                        onError(th2);
                    }
                }
            } else if (z12) {
                this.upstream.cancel();
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }
}
