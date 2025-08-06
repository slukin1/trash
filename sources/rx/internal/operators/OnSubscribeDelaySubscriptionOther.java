package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeDelaySubscriptionOther<T, U> implements Observable.OnSubscribe<T> {
    public final Observable<? extends T> main;
    public final Observable<U> other;

    public OnSubscribeDelaySubscriptionOther(Observable<? extends T> observable, Observable<U> observable2) {
        this.main = observable;
        this.other = observable2;
    }

    public void call(Subscriber<? super T> subscriber) {
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        final Subscriber<? super T> wrap = Subscribers.wrap(subscriber);
        AnonymousClass1 r12 = new Subscriber<U>() {
            public boolean done;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    serialSubscription.set(Subscriptions.unsubscribed());
                    OnSubscribeDelaySubscriptionOther.this.main.unsafeSubscribe(wrap);
                }
            }

            public void onError(Throwable th2) {
                if (this.done) {
                    RxJavaHooks.onError(th2);
                    return;
                }
                this.done = true;
                wrap.onError(th2);
            }

            public void onNext(U u11) {
                onCompleted();
            }
        };
        serialSubscription.set(r12);
        this.other.unsafeSubscribe(r12);
    }
}
