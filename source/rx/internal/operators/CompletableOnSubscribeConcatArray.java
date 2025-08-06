package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

public final class CompletableOnSubscribeConcatArray implements Completable.OnSubscribe {
    public final Completable[] sources;

    public static final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableSubscriber actual;
        public int index;

        /* renamed from: sd  reason: collision with root package name */
        public final SerialSubscription f53400sd = new SerialSubscription();
        public final Completable[] sources;

        public ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Completable[] completableArr) {
            this.actual = completableSubscriber;
            this.sources = completableArr;
        }

        public void next() {
            if (!this.f53400sd.isUnsubscribed() && getAndIncrement() == 0) {
                Completable[] completableArr = this.sources;
                while (!this.f53400sd.isUnsubscribed()) {
                    int i11 = this.index;
                    this.index = i11 + 1;
                    if (i11 == completableArr.length) {
                        this.actual.onCompleted();
                        return;
                    }
                    completableArr[i11].unsafeSubscribe((CompletableSubscriber) this);
                    if (decrementAndGet() == 0) {
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
            this.f53400sd.set(subscription);
        }
    }

    public CompletableOnSubscribeConcatArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, this.sources);
        completableSubscriber.onSubscribe(concatInnerSubscriber.f53400sd);
        concatInnerSubscriber.next();
    }
}
