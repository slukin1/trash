package rx.internal.util;

import com.sumsub.sns.internal.core.analytics.d;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;

public final class ScalarSynchronousObservable<T> extends Observable<T> {
    public static final boolean STRONG_MODE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", d.f31895b)).booleanValue();

    /* renamed from: t  reason: collision with root package name */
    public final T f70925t;

    public static final class JustOnSubscribe<T> implements Observable.OnSubscribe<T> {
        public final T value;

        public JustOnSubscribe(T t11) {
            this.value = t11;
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(ScalarSynchronousObservable.createProducer(subscriber, this.value));
        }
    }

    public static final class ScalarAsyncOnSubscribe<T> implements Observable.OnSubscribe<T> {
        public final Func1<Action0, Subscription> onSchedule;
        public final T value;

        public ScalarAsyncOnSubscribe(T t11, Func1<Action0, Subscription> func1) {
            this.value = t11;
            this.onSchedule = func1;
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(new ScalarAsyncProducer(subscriber, this.value, this.onSchedule));
        }
    }

    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        public final Subscriber<? super T> actual;
        public final Func1<Action0, Subscription> onSchedule;
        public final T value;

        public ScalarAsyncProducer(Subscriber<? super T> subscriber, T t11, Func1<Action0, Subscription> func1) {
            this.actual = subscriber;
            this.value = t11;
            this.onSchedule = func1;
        }

        public void call() {
            Subscriber<? super T> subscriber = this.actual;
            if (!subscriber.isUnsubscribed()) {
                T t11 = this.value;
                try {
                    subscriber.onNext(t11);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) t11);
                }
            }
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j11);
            } else if (i11 != 0 && compareAndSet(false, true)) {
                this.actual.add(this.onSchedule.call(this));
            }
        }

        public String toString() {
            return "ScalarAsyncProducer[" + this.value + ", " + get() + "]";
        }
    }

    public static final class WeakSingleProducer<T> implements Producer {
        public final Subscriber<? super T> actual;
        public boolean once;
        public final T value;

        public WeakSingleProducer(Subscriber<? super T> subscriber, T t11) {
            this.actual = subscriber;
            this.value = t11;
        }

        public void request(long j11) {
            if (!this.once) {
                int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                if (i11 < 0) {
                    throw new IllegalStateException("n >= required but it was " + j11);
                } else if (i11 != 0) {
                    this.once = true;
                    Subscriber<? super T> subscriber = this.actual;
                    if (!subscriber.isUnsubscribed()) {
                        T t11 = this.value;
                        try {
                            subscriber.onNext(t11);
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) t11);
                        }
                    }
                }
            }
        }
    }

    public ScalarSynchronousObservable(T t11) {
        super(RxJavaHooks.onCreate(new JustOnSubscribe(t11)));
        this.f70925t = t11;
    }

    public static <T> ScalarSynchronousObservable<T> create(T t11) {
        return new ScalarSynchronousObservable<>(t11);
    }

    public static <T> Producer createProducer(Subscriber<? super T> subscriber, T t11) {
        if (STRONG_MODE) {
            return new SingleProducer(subscriber, t11);
        }
        return new WeakSingleProducer(subscriber, t11);
    }

    public T get() {
        return this.f70925t;
    }

    public <R> Observable<R> scalarFlatMap(final Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() {
            public void call(Subscriber<? super R> subscriber) {
                Observable observable = (Observable) func1.call(ScalarSynchronousObservable.this.f70925t);
                if (observable instanceof ScalarSynchronousObservable) {
                    subscriber.setProducer(ScalarSynchronousObservable.createProducer(subscriber, ((ScalarSynchronousObservable) observable).f70925t));
                } else {
                    observable.unsafeSubscribe(Subscribers.wrap(subscriber));
                }
            }
        });
    }

    public Observable<T> scalarScheduleOn(final Scheduler scheduler) {
        Func1 func1;
        if (scheduler instanceof EventLoopsScheduler) {
            final EventLoopsScheduler eventLoopsScheduler = (EventLoopsScheduler) scheduler;
            func1 = new Func1<Action0, Subscription>() {
                public Subscription call(Action0 action0) {
                    return eventLoopsScheduler.scheduleDirect(action0);
                }
            };
        } else {
            func1 = new Func1<Action0, Subscription>() {
                public Subscription call(final Action0 action0) {
                    final Scheduler.Worker createWorker = scheduler.createWorker();
                    createWorker.schedule(new Action0() {
                        public void call() {
                            try {
                                action0.call();
                            } finally {
                                createWorker.unsubscribe();
                            }
                        }
                    });
                    return createWorker;
                }
            };
        }
        return Observable.unsafeCreate(new ScalarAsyncOnSubscribe(this.f70925t, func1));
    }
}
