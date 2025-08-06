package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public enum NeverObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    public static final Observable<Object> NEVER = null;

    /* access modifiers changed from: public */
    static {
        NeverObservableHolder neverObservableHolder;
        NEVER = Observable.unsafeCreate(neverObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return NEVER;
    }

    public void call(Subscriber<? super Object> subscriber) {
    }
}
