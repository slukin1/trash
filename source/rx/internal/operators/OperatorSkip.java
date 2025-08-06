package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorSkip<T> implements Observable.Operator<T, T> {
    public final int toSkip;

    public OperatorSkip(int i11) {
        if (i11 >= 0) {
            this.toSkip = i11;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i11);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public int skipped;

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                int i11 = this.skipped;
                if (i11 >= OperatorSkip.this.toSkip) {
                    subscriber.onNext(t11);
                } else {
                    this.skipped = i11 + 1;
                }
            }

            public void setProducer(Producer producer) {
                subscriber.setProducer(producer);
                producer.request((long) OperatorSkip.this.toSkip);
            }
        };
    }
}
