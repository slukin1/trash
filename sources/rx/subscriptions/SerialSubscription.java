package rx.subscriptions;

import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

public final class SerialSubscription implements Subscription {
    public final SequentialSubscription state = new SequentialSubscription();

    public Subscription get() {
        return this.state.current();
    }

    public boolean isUnsubscribed() {
        return this.state.isUnsubscribed();
    }

    public void set(Subscription subscription) {
        if (subscription != null) {
            this.state.update(subscription);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    public void unsubscribe() {
        this.state.unsubscribe();
    }
}
