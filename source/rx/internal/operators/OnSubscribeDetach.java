package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeDetach<T> implements Observable.OnSubscribe<T> {
    public final Observable<T> source;

    public static final class DetachProducer<T> implements Producer, Subscription {
        public final DetachSubscriber<T> parent;

        public DetachProducer(DetachSubscriber<T> detachSubscriber) {
            this.parent = detachSubscriber;
        }

        public boolean isUnsubscribed() {
            return this.parent.isUnsubscribed();
        }

        public void request(long j11) {
            this.parent.innerRequest(j11);
        }

        public void unsubscribe() {
            this.parent.innerUnsubscribe();
        }
    }

    public static final class DetachSubscriber<T> extends Subscriber<T> {
        public final AtomicReference<Subscriber<? super T>> actual;
        public final AtomicReference<Producer> producer = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public DetachSubscriber(Subscriber<? super T> subscriber) {
            this.actual = new AtomicReference<>(subscriber);
        }

        public void innerRequest(long j11) {
            if (j11 >= 0) {
                Producer producer2 = this.producer.get();
                if (producer2 != null) {
                    producer2.request(j11);
                    return;
                }
                BackpressureUtils.getAndAddRequest(this.requested, j11);
                Producer producer3 = this.producer.get();
                if (producer3 != null && producer3 != TerminatedProducer.INSTANCE) {
                    producer3.request(this.requested.getAndSet(0));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j11);
        }

        public void innerUnsubscribe() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            this.actual.lazySet((Object) null);
            unsubscribe();
        }

        public void onCompleted() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber andSet = this.actual.getAndSet((Object) null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber andSet = this.actual.getAndSet((Object) null);
            if (andSet != null) {
                andSet.onError(th2);
            } else {
                RxJavaHooks.onError(th2);
            }
        }

        public void onNext(T t11) {
            Subscriber subscriber = this.actual.get();
            if (subscriber != null) {
                subscriber.onNext(t11);
            }
        }

        public void setProducer(Producer producer2) {
            if (this.producer.compareAndSet((Object) null, producer2)) {
                producer2.request(this.requested.getAndSet(0));
            } else if (this.producer.get() != TerminatedProducer.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }
    }

    public enum TerminatedProducer implements Producer {
        INSTANCE;

        public void request(long j11) {
        }
    }

    public OnSubscribeDetach(Observable<T> observable) {
        this.source = observable;
    }

    public void call(Subscriber<? super T> subscriber) {
        DetachSubscriber detachSubscriber = new DetachSubscriber(subscriber);
        DetachProducer detachProducer = new DetachProducer(detachSubscriber);
        subscriber.add(detachProducer);
        subscriber.setProducer(detachProducer);
        this.source.unsafeSubscribe(detachSubscriber);
    }
}
