package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeTimed<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;

    public static final class TakeSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> child;

        public TakeSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.child = subscriber;
        }

        public void call() {
            onCompleted();
        }

        public void onCompleted() {
            this.child.onCompleted();
            unsubscribe();
        }

        public void onError(Throwable th2) {
            this.child.onError(th2);
            unsubscribe();
        }

        public void onNext(T t11) {
            this.child.onNext(t11);
        }
    }

    public OperatorTakeTimed(long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.time = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        TakeSubscriber takeSubscriber = new TakeSubscriber(new SerializedSubscriber(subscriber));
        createWorker.schedule(takeSubscriber, this.time, this.unit);
        return takeSubscriber;
    }
}
