package rx.internal.util;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public final class ActionSubscriber<T> extends Subscriber<T> {
    public final Action0 onCompleted;
    public final Action1<Throwable> onError;
    public final Action1<? super T> onNext;

    public ActionSubscriber(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        this.onNext = action1;
        this.onError = action12;
        this.onCompleted = action0;
    }

    public void onCompleted() {
        this.onCompleted.call();
    }

    public void onError(Throwable th2) {
        this.onError.call(th2);
    }

    public void onNext(T t11) {
        this.onNext.call(t11);
    }
}
