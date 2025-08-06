package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

public final class BlockingSubscriber<T> extends AtomicReference<d> implements e<T>, d {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue2) {
        this.queue = queue2;
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    public void onError(Throwable th2) {
        this.queue.offer(NotificationLite.error(th2));
    }

    public void onNext(T t11) {
        this.queue.offer(NotificationLite.next(t11));
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    public void request(long j11) {
        ((d) get()).request(j11);
    }
}
