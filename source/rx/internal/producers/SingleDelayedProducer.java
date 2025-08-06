package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    public final Subscriber<? super T> child;
    public T value;

    public SingleDelayedProducer(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    private static <T> void emit(Subscriber<? super T> subscriber, T t11) {
        if (!subscriber.isUnsubscribed()) {
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

    public void request(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i11 != 0) {
            do {
                int i12 = get();
                if (i12 != 0) {
                    if (i12 == 1 && compareAndSet(1, 3)) {
                        emit(this.child, this.value);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public void setValue(T t11) {
        do {
            int i11 = get();
            if (i11 == 0) {
                this.value = t11;
            } else if (i11 == 2 && compareAndSet(2, 3)) {
                emit(this.child, t11);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
