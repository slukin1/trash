package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Observable;
import rx.Subscriber;

public class OperatorSkipLast<T> implements Observable.Operator<T, T> {
    public final int count;

    public OperatorSkipLast(int i11) {
        if (i11 >= 0) {
            this.count = i11;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            private final Deque<Object> deque = new ArrayDeque();

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                if (OperatorSkipLast.this.count == 0) {
                    subscriber.onNext(t11);
                    return;
                }
                if (this.deque.size() == OperatorSkipLast.this.count) {
                    subscriber.onNext(NotificationLite.getValue(this.deque.removeFirst()));
                } else {
                    request(1);
                }
                this.deque.offerLast(NotificationLite.next(t11));
            }
        };
    }
}
