package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import z20.c;
import z20.d;

final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements e<T>, d {
    private static final long serialVersionUID = 1015244841293359600L;
    public final c<? super T> downstream;
    public final Scheduler scheduler;
    public d upstream;

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            FlowableUnsubscribeOn$UnsubscribeSubscriber.this.upstream.cancel();
        }
    }

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(c<? super T> cVar, Scheduler scheduler2) {
        this.downstream = cVar;
        this.scheduler = scheduler2;
    }

    public void cancel() {
        if (compareAndSet(false, true)) {
            this.scheduler.c(new a());
        }
    }

    public void onComplete() {
        if (!get()) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (get()) {
            o00.a.n(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onNext(T t11) {
        if (!get()) {
            this.downstream.onNext(t11);
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        this.upstream.request(j11);
    }
}
