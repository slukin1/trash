package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorSubscribeOn<T> implements Observable.OnSubscribe<T> {
    public final boolean requestOn;
    public final Scheduler scheduler;
    public final Observable<T> source;

    public static final class SubscribeOnSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> actual;
        public final boolean requestOn;
        public Observable<T> source;

        /* renamed from: t  reason: collision with root package name */
        public Thread f53414t;
        public final Scheduler.Worker worker;

        public SubscribeOnSubscriber(Subscriber<? super T> subscriber, boolean z11, Scheduler.Worker worker2, Observable<T> observable) {
            this.actual = subscriber;
            this.requestOn = z11;
            this.worker = worker2;
            this.source = observable;
        }

        public void call() {
            Observable<T> observable = this.source;
            this.source = null;
            this.f53414t = Thread.currentThread();
            observable.unsafeSubscribe(this);
        }

        public void onCompleted() {
            try {
                this.actual.onCompleted();
            } finally {
                this.worker.unsubscribe();
            }
        }

        public void onError(Throwable th2) {
            try {
                this.actual.onError(th2);
            } finally {
                this.worker.unsubscribe();
            }
        }

        public void onNext(T t11) {
            this.actual.onNext(t11);
        }

        public void setProducer(final Producer producer) {
            this.actual.setProducer(new Producer() {
                public void request(final long j11) {
                    if (SubscribeOnSubscriber.this.f53414t != Thread.currentThread()) {
                        SubscribeOnSubscriber subscribeOnSubscriber = SubscribeOnSubscriber.this;
                        if (subscribeOnSubscriber.requestOn) {
                            subscribeOnSubscriber.worker.schedule(new Action0() {
                                public void call() {
                                    producer.request(j11);
                                }
                            });
                            return;
                        }
                    }
                    producer.request(j11);
                }
            });
        }
    }

    public OperatorSubscribeOn(Observable<T> observable, Scheduler scheduler2, boolean z11) {
        this.scheduler = scheduler2;
        this.source = observable;
        this.requestOn = z11;
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, this.requestOn, createWorker, this.source);
        subscriber.add(subscribeOnSubscriber);
        subscriber.add(createWorker);
        createWorker.schedule(subscribeOnSubscriber);
    }
}
