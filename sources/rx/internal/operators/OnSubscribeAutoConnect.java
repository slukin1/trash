package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;

public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements Observable.OnSubscribe<T> {
    public final Action1<? super Subscription> connection;
    public final int numberOfSubscribers;
    public final ConnectableObservable<? extends T> source;

    public OnSubscribeAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i11, Action1<? super Subscription> action1) {
        if (i11 > 0) {
            this.source = connectableObservable;
            this.numberOfSubscribers = i11;
            this.connection = action1;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(Subscriber<? super T> subscriber) {
        this.source.unsafeSubscribe(Subscribers.wrap(subscriber));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.connect(this.connection);
        }
    }
}
