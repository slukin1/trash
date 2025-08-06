package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public enum EmptyObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    public static final Observable<Object> EMPTY = null;

    /* access modifiers changed from: public */
    static {
        EmptyObservableHolder emptyObservableHolder;
        EMPTY = Observable.unsafeCreate(emptyObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return EMPTY;
    }

    public void call(Subscriber<? super Object> subscriber) {
        subscriber.onCompleted();
    }
}
