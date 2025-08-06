package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

public class OperatorSkipLastTimed<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long timeInMillis;

    public OperatorSkipLastTimed(long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeInMillis = timeUnit.toMillis(j11);
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            private Deque<Timestamped<T>> buffer = new ArrayDeque();

            private void emitItemsOutOfWindow(long j11) {
                long j12 = j11 - OperatorSkipLastTimed.this.timeInMillis;
                while (!this.buffer.isEmpty()) {
                    Timestamped first = this.buffer.getFirst();
                    if (first.getTimestampMillis() < j12) {
                        this.buffer.removeFirst();
                        subscriber.onNext(first.getValue());
                    } else {
                        return;
                    }
                }
            }

            public void onCompleted() {
                emitItemsOutOfWindow(OperatorSkipLastTimed.this.scheduler.now());
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                long now = OperatorSkipLastTimed.this.scheduler.now();
                emitItemsOutOfWindow(now);
                this.buffer.offerLast(new Timestamped(now, t11));
            }
        };
    }
}
