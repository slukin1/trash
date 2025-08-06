package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeLast<T> implements Observable.Operator<T, T> {
    public final int count;

    public static final class TakeLastSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        public final Subscriber<? super T> actual;
        public final int count;
        public final ArrayDeque<Object> queue = new ArrayDeque<>();
        public final AtomicLong requested = new AtomicLong();

        public TakeLastSubscriber(Subscriber<? super T> subscriber, int i11) {
            this.actual = subscriber;
            this.count = i11;
        }

        public T call(Object obj) {
            return NotificationLite.getValue(obj);
        }

        public void onCompleted() {
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        public void onError(Throwable th2) {
            this.queue.clear();
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            if (this.queue.size() == this.count) {
                this.queue.poll();
            }
            this.queue.offer(NotificationLite.next(t11));
        }

        public void requestMore(long j11) {
            if (j11 > 0) {
                BackpressureUtils.postCompleteRequest(this.requested, j11, this.queue, this.actual, this);
            }
        }
    }

    public OperatorTakeLast(int i11) {
        if (i11 >= 0) {
            this.count = i11;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastSubscriber takeLastSubscriber = new TakeLastSubscriber(subscriber, this.count);
        subscriber.add(takeLastSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                takeLastSubscriber.requestMore(j11);
            }
        });
        return takeLastSubscriber;
    }
}
