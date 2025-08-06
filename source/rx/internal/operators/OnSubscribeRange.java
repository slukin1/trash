package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeRange implements Observable.OnSubscribe<Integer> {
    private final int endIndex;
    private final int startIndex;

    public static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final Subscriber<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        public RangeProducer(Subscriber<? super Integer> subscriber, int i11, int i12) {
            this.childSubscriber = subscriber;
            this.currentIndex = (long) i11;
            this.endOfRange = i12;
        }

        public void fastPath() {
            long j11 = ((long) this.endOfRange) + 1;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            long j12 = this.currentIndex;
            while (j12 != j11) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(Integer.valueOf((int) j12));
                    j12++;
                } else {
                    return;
                }
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }

        public void request(long j11) {
            if (get() != Long.MAX_VALUE) {
                if (j11 == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j11 > 0 && BackpressureUtils.getAndAddRequest(this, j11) == 0) {
                    slowPath(j11);
                }
            }
        }

        public void slowPath(long j11) {
            long j12 = ((long) this.endOfRange) + 1;
            long j13 = this.currentIndex;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            do {
                long j14 = 0;
                while (true) {
                    if (j14 == j11 || j13 == j12) {
                        if (!subscriber.isUnsubscribed()) {
                            if (j13 == j12) {
                                subscriber.onCompleted();
                                return;
                            }
                            j11 = get();
                            if (j11 == j14) {
                                this.currentIndex = j13;
                                j11 = addAndGet(-j14);
                            }
                        } else {
                            return;
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(Integer.valueOf((int) j13));
                        j13++;
                        j14++;
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public OnSubscribeRange(int i11, int i12) {
        this.startIndex = i11;
        this.endIndex = i12;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new RangeProducer(subscriber, this.startIndex, this.endIndex));
    }
}
