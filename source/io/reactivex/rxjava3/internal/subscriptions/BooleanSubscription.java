package io.reactivex.rxjava3.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import z20.d;

public final class BooleanSubscription extends AtomicBoolean implements d {
    private static final long serialVersionUID = -8127758972444290902L;

    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    public void request(long j11) {
        SubscriptionHelper.validate(j11);
    }

    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
