package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

public final class SingleDelay<T> implements Single.OnSubscribe<T> {
    public final long delay;
    public final Scheduler scheduler;
    public final Single.OnSubscribe<T> source;
    public final TimeUnit unit;

    public static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        public final SingleSubscriber<? super T> actual;
        public final long delay;
        public Throwable error;
        public final TimeUnit unit;
        public T value;

        /* renamed from: w  reason: collision with root package name */
        public final Scheduler.Worker f53416w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Scheduler.Worker worker, long j11, TimeUnit timeUnit) {
            this.actual = singleSubscriber;
            this.f53416w = worker;
            this.delay = j11;
            this.unit = timeUnit;
        }

        public void call() {
            try {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.error = null;
                    this.actual.onError(th2);
                } else {
                    T t11 = this.value;
                    this.value = null;
                    this.actual.onSuccess(t11);
                }
            } finally {
                this.f53416w.unsubscribe();
            }
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.f53416w.schedule(this, this.delay, this.unit);
        }

        public void onSuccess(T t11) {
            this.value = t11;
            this.f53416w.schedule(this, this.delay, this.unit);
        }
    }

    public SingleDelay(Single.OnSubscribe<T> onSubscribe, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = onSubscribe;
        this.scheduler = scheduler2;
        this.delay = j11;
        this.unit = timeUnit;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, createWorker, this.delay, this.unit);
        singleSubscriber.add(createWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }
}
