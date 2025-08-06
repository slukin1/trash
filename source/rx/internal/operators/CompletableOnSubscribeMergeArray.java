package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeArray implements Completable.OnSubscribe {
    public final Completable[] sources;

    public CompletableOnSubscribeMergeArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        CompletableSubscriber completableSubscriber2 = completableSubscriber;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        boolean z11 = true;
        AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        completableSubscriber2.onSubscribe(compositeSubscription);
        Completable[] completableArr = this.sources;
        int length = completableArr.length;
        boolean z12 = false;
        int i11 = 0;
        while (i11 < length) {
            Completable completable = completableArr[i11];
            if (!compositeSubscription.isUnsubscribed()) {
                if (completable == null) {
                    compositeSubscription.unsubscribe();
                    NullPointerException nullPointerException = new NullPointerException("A completable source is null");
                    if (atomicBoolean.compareAndSet(z12, z11)) {
                        completableSubscriber2.onError(nullPointerException);
                        return;
                    }
                    RxJavaHooks.onError(nullPointerException);
                }
                final CompositeSubscription compositeSubscription2 = compositeSubscription;
                final AtomicBoolean atomicBoolean2 = atomicBoolean;
                AnonymousClass1 r102 = r0;
                final CompletableSubscriber completableSubscriber3 = completableSubscriber;
                Completable completable2 = completable;
                final AtomicInteger atomicInteger2 = atomicInteger;
                AnonymousClass1 r02 = new CompletableSubscriber() {
                    public void onCompleted() {
                        if (atomicInteger2.decrementAndGet() == 0 && atomicBoolean2.compareAndSet(false, true)) {
                            completableSubscriber3.onCompleted();
                        }
                    }

                    public void onError(Throwable th2) {
                        compositeSubscription2.unsubscribe();
                        if (atomicBoolean2.compareAndSet(false, true)) {
                            completableSubscriber3.onError(th2);
                        } else {
                            RxJavaHooks.onError(th2);
                        }
                    }

                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription2.add(subscription);
                    }
                };
                completable2.unsafeSubscribe((CompletableSubscriber) r102);
                i11++;
                z11 = true;
                z12 = false;
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
            completableSubscriber.onCompleted();
        }
    }
}
