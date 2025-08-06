package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowableTakeLastTimed$TakeLastTimedSubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final long count;
    public final boolean delayError;
    public volatile boolean done;
    public final c<? super T> downstream;
    public Throwable error;
    public final a<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;
    public d upstream;

    public FlowableTakeLastTimed$TakeLastTimedSubscriber(c<? super T> cVar, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler2, int i11, boolean z11) {
        this.downstream = cVar;
        this.count = j11;
        this.time = j12;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.queue = new a<>(i11);
        this.delayError = z11;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public boolean checkTerminated(boolean z11, c<? super T> cVar, boolean z12) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (!z12) {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            } else if (!z11) {
                return false;
            } else {
                cVar.onComplete();
                return true;
            }
        } else if (!z11) {
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

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            a<Object> aVar = this.queue;
            boolean z11 = this.delayError;
            int i11 = 1;
            do {
                if (this.done) {
                    if (!checkTerminated(aVar.isEmpty(), cVar, z11)) {
                        long j11 = this.requested.get();
                        long j12 = 0;
                        while (true) {
                            if (!checkTerminated(aVar.peek() == null, cVar, z11)) {
                                if (j11 != j12) {
                                    aVar.poll();
                                    cVar.onNext(aVar.poll());
                                    j12++;
                                } else if (j12 != 0) {
                                    b.e(this.requested, j12);
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    public void onComplete() {
        trim(this.scheduler.b(this.unit), this.queue);
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.delayError) {
            trim(this.scheduler.b(this.unit), this.queue);
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        a<Object> aVar = this.queue;
        long b11 = this.scheduler.b(this.unit);
        aVar.l(Long.valueOf(b11), t11);
        trim(b11, aVar);
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

    public void trim(long j11, a<Object> aVar) {
        long j12 = this.time;
        long j13 = this.count;
        boolean z11 = j13 == Long.MAX_VALUE;
        while (!aVar.isEmpty()) {
            if (((Long) aVar.peek()).longValue() < j11 - j12 || (!z11 && ((long) (aVar.n() >> 1)) > j13)) {
                aVar.poll();
                aVar.poll();
            } else {
                return;
            }
        }
    }
}
