package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeTimeout implements Completable.OnSubscribe {
    public final Completable other;
    public final Scheduler scheduler;
    public final Completable source;
    public final long timeout;
    public final TimeUnit unit;

    public CompletableOnSubscribeTimeout(Completable completable, long j11, TimeUnit timeUnit, Scheduler scheduler2, Completable completable2) {
        this.source = completable;
        this.timeout = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.other = completable2;
    }

    public void call(final CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        compositeSubscription.add(createWorker);
        createWorker.schedule(new Action0() {
            public void call() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeSubscription.clear();
                    Completable completable = CompletableOnSubscribeTimeout.this.other;
                    if (completable == null) {
                        completableSubscriber.onError(new TimeoutException());
                    } else {
                        completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                            public void onCompleted() {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onCompleted();
                            }

                            public void onError(Throwable th2) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th2);
                            }

                            public void onSubscribe(Subscription subscription) {
                                compositeSubscription.add(subscription);
                            }
                        });
                    }
                }
            }
        }, this.timeout, this.unit);
        this.source.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onCompleted() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeSubscription.unsubscribe();
                    completableSubscriber.onCompleted();
                }
            }

            public void onError(Throwable th2) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeSubscription.unsubscribe();
                    completableSubscriber.onError(th2);
                    return;
                }
                RxJavaHooks.onError(th2);
            }

            public void onSubscribe(Subscription subscription) {
                compositeSubscription.add(subscription);
            }
        });
    }
}
