package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowableTakeLast$TakeLastSubscriber<T> extends ArrayDeque<T> implements e<T>, d {
    private static final long serialVersionUID = 7240042530241604978L;
    public volatile boolean cancelled;
    public final int count;
    public volatile boolean done;
    public final c<? super T> downstream;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableTakeLast$TakeLastSubscriber(c<? super T> cVar, int i11) {
        this.downstream = cVar;
        this.count = i11;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            long j11 = this.requested.get();
            while (!this.cancelled) {
                if (this.done) {
                    long j12 = 0;
                    while (j12 != j11) {
                        if (!this.cancelled) {
                            Object poll = poll();
                            if (poll == null) {
                                cVar.onComplete();
                                return;
                            } else {
                                cVar.onNext(poll);
                                j12++;
                            }
                        } else {
                            return;
                        }
                    }
                    if (isEmpty()) {
                        cVar.onComplete();
                        return;
                    } else if (j12 != 0) {
                        j11 = b.e(this.requested, j12);
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (this.count == size()) {
            poll();
        }
        offer(t11);
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
