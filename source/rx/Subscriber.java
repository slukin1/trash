package rx;

import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    public Subscriber() {
        this((Subscriber<?>) null, false);
    }

    private void addToRequested(long j11) {
        long j12 = this.requested;
        if (j12 == Long.MIN_VALUE) {
            this.requested = j11;
            return;
        }
        long j13 = j12 + j11;
        if (j13 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j13;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long j11) {
        if (j11 >= 0) {
            synchronized (this) {
                Producer producer2 = this.producer;
                if (producer2 != null) {
                    producer2.request(j11);
                } else {
                    addToRequested(j11);
                }
            }
        } else {
            throw new IllegalArgumentException("number requested cannot be negative: " + j11);
        }
    }

    public void setProducer(Producer producer2) {
        long j11;
        Subscriber<?> subscriber2;
        boolean z11;
        synchronized (this) {
            j11 = this.requested;
            this.producer = producer2;
            subscriber2 = this.subscriber;
            z11 = subscriber2 != null && j11 == Long.MIN_VALUE;
        }
        if (z11) {
            subscriber2.setProducer(producer2);
        } else if (j11 == Long.MIN_VALUE) {
            producer2.request(Long.MAX_VALUE);
        } else {
            producer2.request(j11);
        }
    }

    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public Subscriber(Subscriber<?> subscriber2) {
        this(subscriber2, true);
    }

    public Subscriber(Subscriber<?> subscriber2, boolean z11) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber2;
        this.subscriptions = (!z11 || subscriber2 == null) ? new SubscriptionList() : subscriber2.subscriptions;
    }
}
