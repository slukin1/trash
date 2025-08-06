package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;
import rx.functions.Action0;

public final class Subscriptions {
    private static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();

    public static final class FutureSubscription implements Subscription {

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f53422f;

        public FutureSubscription(Future<?> future) {
            this.f53422f = future;
        }

        public boolean isUnsubscribed() {
            return this.f53422f.isCancelled();
        }

        public void unsubscribe() {
            this.f53422f.cancel(true);
        }
    }

    public static final class Unsubscribed implements Subscription {
        public boolean isUnsubscribed() {
            return true;
        }

        public void unsubscribe() {
        }
    }

    private Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription create(Action0 action0) {
        return BooleanSubscription.create(action0);
    }

    public static Subscription empty() {
        return BooleanSubscription.create();
    }

    public static Subscription from(Future<?> future) {
        return new FutureSubscription(future);
    }

    public static Subscription unsubscribed() {
        return UNSUBSCRIBED;
    }

    public static CompositeSubscription from(Subscription... subscriptionArr) {
        return new CompositeSubscription(subscriptionArr);
    }
}
