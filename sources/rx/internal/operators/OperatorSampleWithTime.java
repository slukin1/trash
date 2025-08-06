package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithTime<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;

    public static final class SamplerSubscriber<T> extends Subscriber<T> implements Action0 {
        private static final Object EMPTY_TOKEN = new Object();
        private final Subscriber<? super T> subscriber;
        public final AtomicReference<Object> value = new AtomicReference<>(EMPTY_TOKEN);

        public SamplerSubscriber(Subscriber<? super T> subscriber2) {
            this.subscriber = subscriber2;
        }

        private void emitIfNonEmpty() {
            AtomicReference<Object> atomicReference = this.value;
            Object obj = EMPTY_TOKEN;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.subscriber.onNext(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }
        }

        public void call() {
            emitIfNonEmpty();
        }

        public void onCompleted() {
            emitIfNonEmpty();
            this.subscriber.onCompleted();
            unsubscribe();
        }

        public void onError(Throwable th2) {
            this.subscriber.onError(th2);
            unsubscribe();
        }

        public void onNext(T t11) {
            this.value.set(t11);
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorSampleWithTime(long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.time = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        SamplerSubscriber samplerSubscriber = new SamplerSubscriber(serializedSubscriber);
        subscriber.add(samplerSubscriber);
        long j11 = this.time;
        createWorker.schedulePeriodically(samplerSubscriber, j11, j11, this.unit);
        return samplerSubscriber;
    }
}
