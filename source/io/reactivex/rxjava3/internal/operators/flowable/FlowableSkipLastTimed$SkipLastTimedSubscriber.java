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

final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
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

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i11, boolean z11) {
        this.downstream = cVar;
        this.time = j11;
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

    public boolean checkTerminated(boolean z11, boolean z12, c<? super T> cVar, boolean z13) {
        if (this.cancelled) {
            this.queue.clear();
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

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            a<Object> aVar = this.queue;
            boolean z11 = this.delayError;
            TimeUnit timeUnit = this.unit;
            Scheduler scheduler2 = this.scheduler;
            long j11 = this.time;
            int i11 = 1;
            do {
                long j12 = this.requested.get();
                long j13 = 0;
                while (j13 != j12) {
                    boolean z12 = this.done;
                    Long l11 = (Long) aVar.peek();
                    boolean z13 = l11 == null;
                    boolean z14 = (z13 || l11.longValue() <= scheduler2.b(timeUnit) - j11) ? z13 : true;
                    if (!checkTerminated(z12, z14, cVar, z11)) {
                        if (z14) {
                            break;
                        }
                        aVar.poll();
                        cVar.onNext(aVar.poll());
                        j13++;
                    } else {
                        return;
                    }
                }
                if (j13 != 0) {
                    b.e(this.requested, j13);
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
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
        this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), t11);
        drain();
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
