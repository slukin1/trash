package rx.internal.util;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousSingle<T> extends Single<T> {
    public final T value;

    public static final class DirectScheduledEmission<T> implements Single.OnSubscribe<T> {

        /* renamed from: es  reason: collision with root package name */
        private final EventLoopsScheduler f70926es;
        private final T value;

        public DirectScheduledEmission(EventLoopsScheduler eventLoopsScheduler, T t11) {
            this.f70926es = eventLoopsScheduler;
            this.value = t11;
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.add(this.f70926es.scheduleDirect(new ScalarSynchronousSingleAction(singleSubscriber, this.value)));
        }
    }

    public static final class NormalScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final Scheduler scheduler;
        private final T value;

        public NormalScheduledEmission(Scheduler scheduler2, T t11) {
            this.scheduler = scheduler2;
            this.value = t11;
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.Worker createWorker = this.scheduler.createWorker();
            singleSubscriber.add(createWorker);
            createWorker.schedule(new ScalarSynchronousSingleAction(singleSubscriber, this.value));
        }
    }

    public static final class ScalarSynchronousSingleAction<T> implements Action0 {
        private final SingleSubscriber<? super T> subscriber;
        private final T value;

        public ScalarSynchronousSingleAction(SingleSubscriber<? super T> singleSubscriber, T t11) {
            this.subscriber = singleSubscriber;
            this.value = t11;
        }

        public void call() {
            try {
                this.subscriber.onSuccess(this.value);
            } catch (Throwable th2) {
                this.subscriber.onError(th2);
            }
        }
    }

    public ScalarSynchronousSingle(final T t11) {
        super(new Single.OnSubscribe<T>() {
            public void call(SingleSubscriber<? super T> singleSubscriber) {
                singleSubscriber.onSuccess(t11);
            }
        });
        this.value = t11;
    }

    public static <T> ScalarSynchronousSingle<T> create(T t11) {
        return new ScalarSynchronousSingle<>(t11);
    }

    public T get() {
        return this.value;
    }

    public <R> Single<R> scalarFlatMap(final Func1<? super T, ? extends Single<? extends R>> func1) {
        return Single.create(new Single.OnSubscribe<R>() {
            public void call(final SingleSubscriber<? super R> singleSubscriber) {
                Single single = (Single) func1.call(ScalarSynchronousSingle.this.value);
                if (single instanceof ScalarSynchronousSingle) {
                    singleSubscriber.onSuccess(((ScalarSynchronousSingle) single).value);
                    return;
                }
                AnonymousClass1 r12 = new SingleSubscriber<R>() {
                    public void onError(Throwable th2) {
                        singleSubscriber.onError(th2);
                    }

                    public void onSuccess(R r11) {
                        singleSubscriber.onSuccess(r11);
                    }
                };
                singleSubscriber.add(r12);
                single.subscribe(r12);
            }
        });
    }

    public Single<T> scalarScheduleOn(Scheduler scheduler) {
        if (scheduler instanceof EventLoopsScheduler) {
            return Single.create(new DirectScheduledEmission((EventLoopsScheduler) scheduler, this.value));
        }
        return Single.create(new NormalScheduledEmission(scheduler, this.value));
    }
}
