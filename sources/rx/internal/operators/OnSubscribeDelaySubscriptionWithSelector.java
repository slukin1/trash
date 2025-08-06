package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.Subscribers;

public final class OnSubscribeDelaySubscriptionWithSelector<T, U> implements Observable.OnSubscribe<T> {
    public final Observable<? extends T> source;
    public final Func0<? extends Observable<U>> subscriptionDelay;

    public OnSubscribeDelaySubscriptionWithSelector(Observable<? extends T> observable, Func0<? extends Observable<U>> func0) {
        this.source = observable;
        this.subscriptionDelay = func0;
    }

    public void call(final Subscriber<? super T> subscriber) {
        try {
            ((Observable) this.subscriptionDelay.call()).take(1).unsafeSubscribe(new Subscriber<U>() {
                public void onCompleted() {
                    OnSubscribeDelaySubscriptionWithSelector.this.source.unsafeSubscribe(Subscribers.wrap(subscriber));
                }

                public void onError(Throwable th2) {
                    subscriber.onError(th2);
                }

                public void onNext(U u11) {
                }
            });
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
        }
    }
}
