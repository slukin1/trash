package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    public final Subscriber<? super T> child;
    public final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t11) {
        this.child = subscriber;
        this.value = t11;
    }

    public void request(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i11 != 0 && compareAndSet(false, true)) {
            Subscriber<? super T> subscriber = this.child;
            if (!subscriber.isUnsubscribed()) {
                T t11 = this.value;
                try {
                    subscriber.onNext(t11);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) t11);
                }
            }
        }
    }
}
