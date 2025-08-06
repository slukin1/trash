package rx.internal.operators;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.util.ExceptionsUtils;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class OnSubscribeFlatMapCompletable<T> implements Observable.OnSubscribe<T> {
    public final boolean delayErrors;
    public final Func1<? super T, ? extends Completable> mapper;
    public final int maxConcurrency;
    public final Observable<T> source;

    public static final class FlatMapCompletableSubscriber<T> extends Subscriber<T> {
        public final Subscriber<? super T> actual;
        public final boolean delayErrors;
        public final AtomicReference<Throwable> errors = new AtomicReference<>();
        public final Func1<? super T, ? extends Completable> mapper;
        public final int maxConcurrency;
        public final CompositeSubscription set = new CompositeSubscription();
        public final AtomicInteger wip = new AtomicInteger(1);

        public final class InnerSubscriber extends AtomicReference<Subscription> implements CompletableSubscriber, Subscription {
            private static final long serialVersionUID = -8588259593722659900L;

            public InnerSubscriber() {
            }

            public boolean isUnsubscribed() {
                return get() == this;
            }

            public void onCompleted() {
                FlatMapCompletableSubscriber.this.innerComplete(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableSubscriber.this.innerError(this, th2);
            }

            public void onSubscribe(Subscription subscription) {
                if (!compareAndSet((Object) null, subscription)) {
                    subscription.unsubscribe();
                    if (get() != this) {
                        RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                    }
                }
            }

            public void unsubscribe() {
                Subscription subscription = (Subscription) getAndSet(this);
                if (subscription != null && subscription != this) {
                    subscription.unsubscribe();
                }
            }
        }

        public FlatMapCompletableSubscriber(Subscriber<? super T> subscriber, Func1<? super T, ? extends Completable> func1, boolean z11, int i11) {
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrors = z11;
            this.maxConcurrency = i11;
            request(i11 != Integer.MAX_VALUE ? (long) i11 : Long.MAX_VALUE);
        }

        public boolean done() {
            if (this.wip.decrementAndGet() != 0) {
                return false;
            }
            Throwable terminate = ExceptionsUtils.terminate(this.errors);
            if (terminate != null) {
                this.actual.onError(terminate);
                return true;
            }
            this.actual.onCompleted();
            return true;
        }

        public void innerComplete(FlatMapCompletableSubscriber<T>.InnerSubscriber innerSubscriber) {
            this.set.remove(innerSubscriber);
            if (!done() && this.maxConcurrency != Integer.MAX_VALUE) {
                request(1);
            }
        }

        public void innerError(FlatMapCompletableSubscriber<T>.InnerSubscriber innerSubscriber, Throwable th2) {
            this.set.remove(innerSubscriber);
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th2);
                if (!done() && this.maxConcurrency != Integer.MAX_VALUE) {
                    request(1);
                    return;
                }
                return;
            }
            this.set.unsubscribe();
            unsubscribe();
            if (this.errors.compareAndSet((Object) null, th2)) {
                this.actual.onError(ExceptionsUtils.terminate(this.errors));
            } else {
                RxJavaHooks.onError(th2);
            }
        }

        public void onCompleted() {
            done();
        }

        public void onError(Throwable th2) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th2);
                onCompleted();
                return;
            }
            this.set.unsubscribe();
            if (this.errors.compareAndSet((Object) null, th2)) {
                this.actual.onError(ExceptionsUtils.terminate(this.errors));
            } else {
                RxJavaHooks.onError(th2);
            }
        }

        public void onNext(T t11) {
            try {
                Completable completable = (Completable) this.mapper.call(t11);
                if (completable != null) {
                    InnerSubscriber innerSubscriber = new InnerSubscriber();
                    this.set.add(innerSubscriber);
                    this.wip.getAndIncrement();
                    completable.unsafeSubscribe((CompletableSubscriber) innerSubscriber);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Completable");
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                onError(th2);
            }
        }
    }

    public OnSubscribeFlatMapCompletable(Observable<T> observable, Func1<? super T, ? extends Completable> func1, boolean z11, int i11) {
        Objects.requireNonNull(func1, "mapper is null");
        if (i11 > 0) {
            this.source = observable;
            this.mapper = func1;
            this.delayErrors = z11;
            this.maxConcurrency = i11;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i11);
    }

    public void call(Subscriber<? super T> subscriber) {
        FlatMapCompletableSubscriber flatMapCompletableSubscriber = new FlatMapCompletableSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency);
        subscriber.add(flatMapCompletableSubscriber);
        subscriber.add(flatMapCompletableSubscriber.set);
        this.source.unsafeSubscribe(flatMapCompletableSubscriber);
    }
}
