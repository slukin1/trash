package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.producers.SingleProducer;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeToObservableFuture {

    public static class ToObservableFuture<T> implements Observable.OnSubscribe<T> {
        public final Future<? extends T> that;
        private final long time;
        private final TimeUnit unit;

        public ToObservableFuture(Future<? extends T> future) {
            this.that = future;
            this.time = 0;
            this.unit = null;
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.add(Subscriptions.create(new Action0() {
                public void call() {
                    ToObservableFuture.this.that.cancel(true);
                }
            }));
            try {
                if (!subscriber.isUnsubscribed()) {
                    TimeUnit timeUnit = this.unit;
                    subscriber.setProducer(new SingleProducer(subscriber, timeUnit == null ? this.that.get() : this.that.get(this.time, timeUnit)));
                }
            } catch (Throwable th2) {
                if (!subscriber.isUnsubscribed()) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                }
            }
        }

        public ToObservableFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
            this.that = future;
            this.time = j11;
            this.unit = timeUnit;
        }
    }

    private OnSubscribeToObservableFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> future) {
        return new ToObservableFuture(future);
    }

    public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        return new ToObservableFuture(future, j11, timeUnit);
    }
}
