package rx.internal.operators;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

public final class SingleObserveOn<T> implements Single.OnSubscribe<T> {
    public final Scheduler scheduler;
    public final Single.OnSubscribe<T> source;

    public static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        public final SingleSubscriber<? super T> actual;
        public Throwable error;
        public T value;

        /* renamed from: w  reason: collision with root package name */
        public final Scheduler.Worker f53417w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Scheduler.Worker worker) {
            this.actual = singleSubscriber;
            this.f53417w = worker;
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
                this.f53417w.unsubscribe();
            }
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.f53417w.schedule(this);
        }

        public void onSuccess(T t11) {
            this.value = t11;
            this.f53417w.schedule(this);
        }
    }

    public SingleObserveOn(Single.OnSubscribe<T> onSubscribe, Scheduler scheduler2) {
        this.source = onSubscribe;
        this.scheduler = scheduler2;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, createWorker);
        singleSubscriber.add(createWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }
}
