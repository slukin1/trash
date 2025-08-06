package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

public final class OnSubscribeTimerPeriodically implements Observable.OnSubscribe<Long> {
    public final long initialDelay;
    public final long period;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    public OnSubscribeTimerPeriodically(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler2) {
        this.initialDelay = j11;
        this.period = j12;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void call(final Subscriber<? super Long> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        createWorker.schedulePeriodically(new Action0() {
            public long counter;

            public void call() {
                try {
                    Subscriber subscriber = subscriber;
                    long j11 = this.counter;
                    this.counter = 1 + j11;
                    subscriber.onNext(Long.valueOf(j11));
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                    throw th2;
                }
            }
        }, this.initialDelay, this.period, this.unit);
    }
}
