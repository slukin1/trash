package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public final class OnSubscribeDelaySubscription<T> implements Observable.OnSubscribe<T> {
    public final Scheduler scheduler;
    public final Observable<? extends T> source;
    public final long time;
    public final TimeUnit unit;

    public OnSubscribeDelaySubscription(Observable<? extends T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = observable;
        this.time = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void call(final Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        createWorker.schedule(new Action0() {
            public void call() {
                if (!subscriber.isUnsubscribed()) {
                    OnSubscribeDelaySubscription.this.source.unsafeSubscribe(Subscribers.wrap(subscriber));
                }
            }
        }, this.time, this.unit);
    }
}
