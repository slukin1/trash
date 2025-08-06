package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T> implements Observable.Operator<T, Observable<T>> {
    public final Func2<Integer, Throwable, Boolean> predicate;

    public static final class SourceSubscriber<T> extends Subscriber<Observable<T>> {
        public final AtomicInteger attempts = new AtomicInteger();
        public final Subscriber<? super T> child;
        public final Scheduler.Worker inner;

        /* renamed from: pa  reason: collision with root package name */
        public final ProducerArbiter f53413pa;
        public final Func2<Integer, Throwable, Boolean> predicate;
        public final SerialSubscription serialSubscription;

        public SourceSubscriber(Subscriber<? super T> subscriber, Func2<Integer, Throwable, Boolean> func2, Scheduler.Worker worker, SerialSubscription serialSubscription2, ProducerArbiter producerArbiter) {
            this.child = subscriber;
            this.predicate = func2;
            this.inner = worker;
            this.serialSubscription = serialSubscription2;
            this.f53413pa = producerArbiter;
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            this.child.onError(th2);
        }

        public void onNext(final Observable<T> observable) {
            this.inner.schedule(new Action0() {
                public void call() {
                    SourceSubscriber.this.attempts.incrementAndGet();
                    AnonymousClass1 r02 = new Subscriber<T>() {
                        public boolean done;

                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber.this.child.onCompleted();
                            }
                        }

                        public void onError(Throwable th2) {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber sourceSubscriber = SourceSubscriber.this;
                                if (!sourceSubscriber.predicate.call(Integer.valueOf(sourceSubscriber.attempts.get()), th2).booleanValue() || SourceSubscriber.this.inner.isUnsubscribed()) {
                                    SourceSubscriber.this.child.onError(th2);
                                } else {
                                    SourceSubscriber.this.inner.schedule(this);
                                }
                            }
                        }

                        public void onNext(T t11) {
                            if (!this.done) {
                                SourceSubscriber.this.child.onNext(t11);
                                SourceSubscriber.this.f53413pa.produced(1);
                            }
                        }

                        public void setProducer(Producer producer) {
                            SourceSubscriber.this.f53413pa.setProducer(producer);
                        }
                    };
                    SourceSubscriber.this.serialSubscription.set(r02);
                    observable.unsafeSubscribe(r02);
                }
            });
        }
    }

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
        this.predicate = func2;
    }

    public Subscriber<? super Observable<T>> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = Schedulers.trampoline().createWorker();
        subscriber.add(createWorker);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        ProducerArbiter producerArbiter = new ProducerArbiter();
        subscriber.setProducer(producerArbiter);
        return new SourceSubscriber(subscriber, this.predicate, createWorker, serialSubscription, producerArbiter);
    }
}
