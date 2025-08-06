package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorDelay<T> implements Observable.Operator<T, T> {
    public final long delay;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    public OperatorDelay(long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.delay = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        return new Subscriber<T>(subscriber) {
            public boolean done;

            public void onCompleted() {
                Scheduler.Worker worker = createWorker;
                AnonymousClass1 r12 = new Action0() {
                    public void call() {
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        if (!r02.done) {
                            r02.done = true;
                            subscriber.onCompleted();
                        }
                    }
                };
                OperatorDelay operatorDelay = OperatorDelay.this;
                worker.schedule(r12, operatorDelay.delay, operatorDelay.unit);
            }

            public void onError(final Throwable th2) {
                createWorker.schedule(new Action0() {
                    public void call() {
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        if (!r02.done) {
                            r02.done = true;
                            subscriber.onError(th2);
                            createWorker.unsubscribe();
                        }
                    }
                });
            }

            public void onNext(final T t11) {
                Scheduler.Worker worker = createWorker;
                AnonymousClass3 r12 = new Action0() {
                    public void call() {
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        if (!r02.done) {
                            subscriber.onNext(t11);
                        }
                    }
                };
                OperatorDelay operatorDelay = OperatorDelay.this;
                worker.schedule(r12, operatorDelay.delay, operatorDelay.unit);
            }
        };
    }
}
