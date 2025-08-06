package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorThrottleFirst<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long timeInMilliseconds;

    public OperatorThrottleFirst(long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeInMilliseconds = timeUnit.toMillis(j11);
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            private long lastOnNext = -1;

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                long now = OperatorThrottleFirst.this.scheduler.now();
                long j11 = this.lastOnNext;
                if (j11 == -1 || now < j11 || now - j11 >= OperatorThrottleFirst.this.timeInMilliseconds) {
                    this.lastOnNext = now;
                    subscriber.onNext(t11);
                }
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}
