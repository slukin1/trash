package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class SingleTimeout<T> implements Single.OnSubscribe<T> {
    public final Single.OnSubscribe<? extends T> other;
    public final Scheduler scheduler;
    public final Single.OnSubscribe<T> source;
    public final long timeout;
    public final TimeUnit unit;

    public static final class TimeoutSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        public final SingleSubscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final Single.OnSubscribe<? extends T> other;

        public static final class OtherSubscriber<T> extends SingleSubscriber<T> {
            public final SingleSubscriber<? super T> actual;

            public OtherSubscriber(SingleSubscriber<? super T> singleSubscriber) {
                this.actual = singleSubscriber;
            }

            public void onError(Throwable th2) {
                this.actual.onError(th2);
            }

            public void onSuccess(T t11) {
                this.actual.onSuccess(t11);
            }
        }

        public TimeoutSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Single.OnSubscribe<? extends T> onSubscribe) {
            this.actual = singleSubscriber;
            this.other = onSubscribe;
        }

        public void call() {
            if (this.once.compareAndSet(false, true)) {
                try {
                    Single.OnSubscribe<? extends T> onSubscribe = this.other;
                    if (onSubscribe == null) {
                        this.actual.onError(new TimeoutException());
                    } else {
                        OtherSubscriber otherSubscriber = new OtherSubscriber(this.actual);
                        this.actual.add(otherSubscriber);
                        onSubscribe.call(otherSubscriber);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.once.compareAndSet(false, true)) {
                try {
                    this.actual.onError(th2);
                } finally {
                    unsubscribe();
                }
            } else {
                RxJavaHooks.onError(th2);
            }
        }

        public void onSuccess(T t11) {
            if (this.once.compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t11);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    public SingleTimeout(Single.OnSubscribe<T> onSubscribe, long j11, TimeUnit timeUnit, Scheduler scheduler2, Single.OnSubscribe<? extends T> onSubscribe2) {
        this.source = onSubscribe;
        this.timeout = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.other = onSubscribe2;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TimeoutSingleSubscriber timeoutSingleSubscriber = new TimeoutSingleSubscriber(singleSubscriber, this.other);
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        timeoutSingleSubscriber.add(createWorker);
        singleSubscriber.add(timeoutSingleSubscriber);
        createWorker.schedule(timeoutSingleSubscriber, this.timeout, this.unit);
        this.source.call(timeoutSingleSubscriber);
    }
}
