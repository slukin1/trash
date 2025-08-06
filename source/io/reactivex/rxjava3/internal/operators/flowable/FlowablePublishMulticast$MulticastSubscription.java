package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements d {
    private static final long serialVersionUID = 8664815189257569791L;
    public final c<? super T> downstream;
    public long emitted;
    public final j<T> parent;

    public FlowablePublishMulticast$MulticastSubscription(c<? super T> cVar, j<T> jVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            throw null;
        }
    }

    public boolean isCancelled() {
        return get() == Long.MIN_VALUE;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.b(this, j11);
            throw null;
        }
    }
}
