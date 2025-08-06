package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.TimeInterval;

public final class OperatorTimeInterval<T> implements Observable.Operator<TimeInterval<T>, T> {
    public final Scheduler scheduler;

    public OperatorTimeInterval(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super TimeInterval<T>> subscriber) {
        return new Subscriber<T>(subscriber) {
            private long lastTimestamp;

            {
                this.lastTimestamp = OperatorTimeInterval.this.scheduler.now();
            }

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                long now = OperatorTimeInterval.this.scheduler.now();
                subscriber.onNext(new TimeInterval(now - this.lastTimestamp, t11));
                this.lastTimestamp = now;
            }
        };
    }
}
