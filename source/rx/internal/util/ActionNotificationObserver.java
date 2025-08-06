package rx.internal.util;

import rx.Notification;
import rx.Observer;
import rx.functions.Action1;

public final class ActionNotificationObserver<T> implements Observer<T> {
    public final Action1<Notification<? super T>> onNotification;

    public ActionNotificationObserver(Action1<Notification<? super T>> action1) {
        this.onNotification = action1;
    }

    public void onCompleted() {
        this.onNotification.call(Notification.createOnCompleted());
    }

    public void onError(Throwable th2) {
        this.onNotification.call(Notification.createOnError(th2));
    }

    public void onNext(T t11) {
        this.onNotification.call(Notification.createOnNext(t11));
    }
}
