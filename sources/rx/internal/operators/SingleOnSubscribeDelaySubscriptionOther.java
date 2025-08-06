package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class SingleOnSubscribeDelaySubscriptionOther<T> implements Single.OnSubscribe<T> {
    public final Single<? extends T> main;
    public final Observable<?> other;

    public SingleOnSubscribeDelaySubscriptionOther(Single<? extends T> single, Observable<?> observable) {
        this.main = single;
        this.other = observable;
    }

    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        final AnonymousClass1 r02 = new SingleSubscriber<T>() {
            public void onError(Throwable th2) {
                singleSubscriber.onError(th2);
            }

            public void onSuccess(T t11) {
                singleSubscriber.onSuccess(t11);
            }
        };
        final SerialSubscription serialSubscription = new SerialSubscription();
        singleSubscriber.add(serialSubscription);
        AnonymousClass2 r32 = new Subscriber<Object>() {
            public boolean done;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    serialSubscription.set(r02);
                    SingleOnSubscribeDelaySubscriptionOther.this.main.subscribe(r02);
                }
            }

            public void onError(Throwable th2) {
                if (this.done) {
                    RxJavaHooks.onError(th2);
                    return;
                }
                this.done = true;
                r02.onError(th2);
            }

            public void onNext(Object obj) {
                onCompleted();
            }
        };
        serialSubscription.set(r32);
        this.other.subscribe(r32);
    }
}
