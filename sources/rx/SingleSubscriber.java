package rx;

import rx.internal.util.SubscriptionList;

public abstract class SingleSubscriber<T> implements Subscription {

    /* renamed from: cs  reason: collision with root package name */
    private final SubscriptionList f29196cs = new SubscriptionList();

    public final void add(Subscription subscription) {
        this.f29196cs.add(subscription);
    }

    public final boolean isUnsubscribed() {
        return this.f29196cs.isUnsubscribed();
    }

    public abstract void onError(Throwable th2);

    public abstract void onSuccess(T t11);

    public final void unsubscribe() {
        this.f29196cs.unsubscribe();
    }
}
