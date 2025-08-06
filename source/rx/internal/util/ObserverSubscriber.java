package rx.internal.util;

import rx.Observer;
import rx.Subscriber;

public final class ObserverSubscriber<T> extends Subscriber<T> {
    public final Observer<? super T> observer;

    public ObserverSubscriber(Observer<? super T> observer2) {
        this.observer = observer2;
    }

    public void onCompleted() {
        this.observer.onCompleted();
    }

    public void onError(Throwable th2) {
        this.observer.onError(th2);
    }

    public void onNext(T t11) {
        this.observer.onNext(t11);
    }
}
