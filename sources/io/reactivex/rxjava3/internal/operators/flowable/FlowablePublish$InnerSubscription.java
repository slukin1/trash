package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowablePublish$InnerSubscription<T> extends AtomicLong implements d {
    private static final long serialVersionUID = 2845000326761540265L;
    public final c<? super T> downstream;
    public long emitted;
    public final FlowablePublish$PublishConnection<T> parent;

    public FlowablePublish$InnerSubscription(c<? super T> cVar, FlowablePublish$PublishConnection<T> flowablePublish$PublishConnection) {
        this.downstream = cVar;
        this.parent = flowablePublish$PublishConnection;
    }

    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.remove(this);
            this.parent.drain();
        }
    }

    public boolean isCancelled() {
        return get() == Long.MIN_VALUE;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.b(this, j11);
            this.parent.drain();
        }
    }
}
