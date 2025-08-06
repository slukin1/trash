package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 1;
    public static final int NO_REQUEST_HAS_VALUE = 2;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public final Subscriber<? super R> actual;
    public boolean hasValue;
    public final AtomicInteger state = new AtomicInteger();
    public R value;

    public static final class InnerProducer implements Producer {
        public final DeferredScalarSubscriber<?, ?> parent;

        public InnerProducer(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.parent = deferredScalarSubscriber;
        }

        public void request(long j11) {
            this.parent.downstreamRequest(j11);
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    public final void complete() {
        this.actual.onCompleted();
    }

    public final void downstreamRequest(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j11);
        } else if (i11 != 0) {
            Subscriber<? super R> subscriber = this.actual;
            do {
                int i12 = this.state.get();
                if (i12 != 1 && i12 != 3 && !subscriber.isUnsubscribed()) {
                    if (i12 == 2) {
                        if (this.state.compareAndSet(2, 3)) {
                            subscriber.onNext(this.value);
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.state.compareAndSet(0, 1));
        }
    }

    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    public void onError(Throwable th2) {
        this.value = null;
        this.actual.onError(th2);
    }

    public final void setProducer(Producer producer) {
        producer.request(Long.MAX_VALUE);
    }

    public final void setupDownstream() {
        Subscriber<? super R> subscriber = this.actual;
        subscriber.add(this);
        subscriber.setProducer(new InnerProducer(this));
    }

    public final void subscribeTo(Observable<? extends T> observable) {
        setupDownstream();
        observable.unsafeSubscribe(this);
    }

    public final void complete(R r11) {
        Subscriber<? super R> subscriber = this.actual;
        do {
            int i11 = this.state.get();
            if (i11 != 2 && i11 != 3 && !subscriber.isUnsubscribed()) {
                if (i11 == 1) {
                    subscriber.onNext(r11);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                    this.state.lazySet(3);
                    return;
                }
                this.value = r11;
            } else {
                return;
            }
        } while (!this.state.compareAndSet(0, 2));
    }
}
