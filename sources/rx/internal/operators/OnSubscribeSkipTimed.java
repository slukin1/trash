package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OnSubscribeSkipTimed<T> implements Observable.OnSubscribe<T> {
    public final Scheduler scheduler;
    public final Observable<T> source;
    public final long time;
    public final TimeUnit unit;

    public static final class SkipTimedSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> child;
        public volatile boolean gate;

        public SkipTimedSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        public void call() {
            this.gate = true;
        }

        public void onCompleted() {
            try {
                this.child.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        public void onError(Throwable th2) {
            try {
                this.child.onError(th2);
            } finally {
                unsubscribe();
            }
        }

        public void onNext(T t11) {
            if (this.gate) {
                this.child.onNext(t11);
            }
        }
    }

    public OnSubscribeSkipTimed(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = observable;
        this.time = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SkipTimedSubscriber skipTimedSubscriber = new SkipTimedSubscriber(subscriber);
        skipTimedSubscriber.add(createWorker);
        subscriber.add(skipTimedSubscriber);
        createWorker.schedule(skipTimedSubscriber, this.time, this.unit);
        this.source.unsafeSubscribe(skipTimedSubscriber);
    }
}
