package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeLastTimed<T> implements Observable.Operator<T, T> {
    public final long ageMillis;
    public final int count;
    public final Scheduler scheduler;

    public static final class TakeLastTimedSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        public final Subscriber<? super T> actual;
        public final long ageMillis;
        public final int count;
        public final ArrayDeque<Object> queue = new ArrayDeque<>();
        public final ArrayDeque<Long> queueTimes = new ArrayDeque<>();
        public final AtomicLong requested = new AtomicLong();
        public final Scheduler scheduler;

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, int i11, long j11, Scheduler scheduler2) {
            this.actual = subscriber;
            this.count = i11;
            this.ageMillis = j11;
            this.scheduler = scheduler2;
        }

        public T call(Object obj) {
            return NotificationLite.getValue(obj);
        }

        public void evictOld(long j11) {
            long j12 = j11 - this.ageMillis;
            while (true) {
                Long peek = this.queueTimes.peek();
                if (peek != null && peek.longValue() < j12) {
                    this.queue.poll();
                    this.queueTimes.poll();
                } else {
                    return;
                }
            }
        }

        public void onCompleted() {
            evictOld(this.scheduler.now());
            this.queueTimes.clear();
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        public void onError(Throwable th2) {
            this.queue.clear();
            this.queueTimes.clear();
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            if (this.count != 0) {
                long now = this.scheduler.now();
                if (this.queue.size() == this.count) {
                    this.queue.poll();
                    this.queueTimes.poll();
                }
                evictOld(now);
                this.queue.offer(NotificationLite.next(t11));
                this.queueTimes.offer(Long.valueOf(now));
            }
        }

        public void requestMore(long j11) {
            BackpressureUtils.postCompleteRequest(this.requested, j11, this.queue, this.actual, this);
        }
    }

    public OperatorTakeLastTimed(long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.ageMillis = timeUnit.toMillis(j11);
        this.scheduler = scheduler2;
        this.count = -1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastTimedSubscriber takeLastTimedSubscriber = new TakeLastTimedSubscriber(subscriber, this.count, this.ageMillis, this.scheduler);
        subscriber.add(takeLastTimedSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                takeLastTimedSubscriber.requestMore(j11);
            }
        });
        return takeLastTimedSubscriber;
    }

    public OperatorTakeLastTimed(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        if (i11 >= 0) {
            this.ageMillis = timeUnit.toMillis(j11);
            this.scheduler = scheduler2;
            this.count = i11;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
