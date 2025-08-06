package rx;

import rx.functions.Cancellable;

public interface CompletableEmitter {
    void onCompleted();

    void onError(Throwable th2);

    void setCancellation(Cancellable cancellable);

    void setSubscription(Subscription subscription);
}
