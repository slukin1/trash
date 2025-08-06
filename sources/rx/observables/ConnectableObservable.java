package rx.observables;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.OnSubscribeAutoConnect;
import rx.internal.operators.OnSubscribeRefCount;

public abstract class ConnectableObservable<T> extends Observable<T> {
    public ConnectableObservable(Observable.OnSubscribe<T> onSubscribe) {
        super(onSubscribe);
    }

    public Observable<T> autoConnect() {
        return autoConnect(1);
    }

    public final Subscription connect() {
        final Subscription[] subscriptionArr = new Subscription[1];
        connect(new Action1<Subscription>() {
            public void call(Subscription subscription) {
                subscriptionArr[0] = subscription;
            }
        });
        return subscriptionArr[0];
    }

    public abstract void connect(Action1<? super Subscription> action1);

    public Observable<T> refCount() {
        return Observable.unsafeCreate(new OnSubscribeRefCount(this));
    }

    public Observable<T> autoConnect(int i11) {
        return autoConnect(i11, Actions.empty());
    }

    public Observable<T> autoConnect(int i11, Action1<? super Subscription> action1) {
        if (i11 > 0) {
            return Observable.unsafeCreate(new OnSubscribeAutoConnect(this, i11, action1));
        }
        connect(action1);
        return this;
    }
}
