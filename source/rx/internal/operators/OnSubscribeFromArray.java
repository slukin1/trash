package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeFromArray<T> implements Observable.OnSubscribe<T> {
    public final T[] array;

    public static final class FromArrayProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;
        public final T[] array;
        public final Subscriber<? super T> child;
        public int index;

        public FromArrayProducer(Subscriber<? super T> subscriber, T[] tArr) {
            this.child = subscriber;
            this.array = tArr;
        }

        public void fastPath() {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i11 = 0;
            while (i11 < length) {
                T t11 = tArr[i11];
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(t11);
                    i11++;
                } else {
                    return;
                }
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j11);
            } else if (j11 == Long.MAX_VALUE) {
                if (BackpressureUtils.getAndAddRequest(this, j11) == 0) {
                    fastPath();
                }
            } else if (i11 != 0 && BackpressureUtils.getAndAddRequest(this, j11) == 0) {
                slowPath(j11);
            }
        }

        public void slowPath(long j11) {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i11 = this.index;
            do {
                long j12 = 0;
                while (true) {
                    if (r11 == 0 || i11 == length) {
                        r11 = get() + j12;
                        if (r11 == 0) {
                            this.index = i11;
                            j11 = addAndGet(j12);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(tArr[i11]);
                        i11++;
                        if (i11 != length) {
                            r11--;
                            j12--;
                        } else if (!subscriber.isUnsubscribed()) {
                            subscriber.onCompleted();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.array = tArr;
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.setProducer(new FromArrayProducer(subscriber, this.array));
    }
}
