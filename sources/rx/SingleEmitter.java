package rx;

import rx.functions.Cancellable;

public interface SingleEmitter<T> {
    void onError(Throwable th2);

    void onSuccess(T t11);

    void setCancellation(Cancellable cancellable);

    void setSubscription(Subscription subscription);
}
