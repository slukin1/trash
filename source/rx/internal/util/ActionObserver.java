package rx.internal.util;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public final class ActionObserver<T> implements Observer<T> {
    public final Action0 onCompleted;
    public final Action1<? super Throwable> onError;
    public final Action1<? super T> onNext;

    public ActionObserver(Action1<? super T> action1, Action1<? super Throwable> action12, Action0 action0) {
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
