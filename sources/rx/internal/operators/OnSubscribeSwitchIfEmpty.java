package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeSwitchIfEmpty<T> implements Observable.OnSubscribe<T> {
    public final Observable<? extends T> alternate;
    public final Observable<? extends T> source;

    public static final class AlternateSubscriber<T> extends Subscriber<T> {
        private final ProducerArbiter arbiter;
        private final Subscriber<? super T> child;

        public AlternateSubscriber(Subscriber<? super T> subscriber, ProducerArbiter producerArbiter) {
            this.child = subscriber;
            this.arbiter = producerArbiter;
        }

        public void onCompleted() {
            this.child.onCompleted();
        }

        public void onError(Throwable th2) {
            this.child.onError(th2);
        }

        public void onNext(T t11) {
            this.child.onNext(t11);
            this.arbiter.produced(1);
        }

        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        public volatile boolean active;
        private final Observable<? extends T> alternate;
        private final ProducerArbiter arbiter;
        private final Subscriber<? super T> child;
        private boolean empty = true;
        private final SerialSubscription serial;
        public final AtomicInteger wip;

        public ParentSubscriber(Subscriber<? super T> subscriber, SerialSubscription serialSubscription, ProducerArbiter producerArbiter, Observable<? extends T> observable) {
            this.child = subscriber;
            this.serial = serialSubscription;
            this.arbiter = producerArbiter;
            this.alternate = observable;
            this.wip = new AtomicInteger();
        }

        public void onCompleted() {
            if (!this.empty) {
                this.child.onCompleted();
            } else if (!this.child.isUnsubscribed()) {
                this.active = false;
                subscribe((Observable) null);
            }
        }

        public void onError(Throwable th2) {
            this.child.onError(th2);
        }

        public void onNext(T t11) {
            this.empty = false;
            this.child.onNext(t11);
            this.arbiter.produced(1);
        }

        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }

        public void subscribe(Observable<? extends T> observable) {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.child.isUnsubscribed()) {
                    if (!this.active) {
                        if (observable == null) {
                            AlternateSubscriber alternateSubscriber = new AlternateSubscriber(this.child, this.arbiter);
                            this.serial.set(alternateSubscriber);
                            this.active = true;
                            this.alternate.unsafeSubscribe(alternateSubscriber);
                        } else {
                            this.active = true;
                            observable.unsafeSubscribe(this);
                            observable = null;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public OnSubscribeSwitchIfEmpty(Observable<? extends T> observable, Observable<? extends T> observable2) {
        this.source = observable;
        this.alternate = observable2;
    }

    public void call(Subscriber<? super T> subscriber) {
        SerialSubscription serialSubscription = new SerialSubscription();
        ProducerArbiter producerArbiter = new ProducerArbiter();
        ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber, serialSubscription, producerArbiter, this.alternate);
        serialSubscription.set(parentSubscriber);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        parentSubscriber.subscribe(this.source);
    }
}
