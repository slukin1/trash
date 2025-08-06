package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class CompletableOnSubscribeConcatIterable implements Completable.OnSubscribe {
    public final Iterable<? extends Completable> sources;

    public static final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableSubscriber actual;

        /* renamed from: sd  reason: collision with root package name */
        public final SerialSubscription f53401sd = new SerialSubscription();
        public final Iterator<? extends Completable> sources;

        public ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Iterator<? extends Completable> it2) {
            this.actual = completableSubscriber;
            this.sources = it2;
        }

        public void next() {
            if (!this.f53401sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends Completable> it2 = this.sources;
                while (!this.f53401sd.isUnsubscribed()) {
                    try {
                        if (!it2.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            Completable completable = (Completable) it2.next();
                            if (completable == null) {
                                this.actual.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            completable.unsafeSubscribe((CompletableSubscriber) this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th2) {
                            this.actual.onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        this.actual.onError(th3);
                        return;
                    }
                }
            }
        }

        public void onCompleted() {
            next();
        }

        public void onError(Throwable th2) {
            this.actual.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            this.f53401sd.set(subscription);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        try {
            Iterator<? extends Completable> it2 = this.sources.iterator();
            if (it2 == null) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, it2);
            completableSubscriber.onSubscribe(concatInnerSubscriber.f53401sd);
            concatInnerSubscriber.next();
        } catch (Throwable th2) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
            completableSubscriber.onError(th2);
        }
    }
}
