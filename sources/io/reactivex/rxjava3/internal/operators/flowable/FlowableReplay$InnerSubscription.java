package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements d, b {
    public static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    public final c<? super T> child;
    public boolean emitting;
    public Object index;
    public boolean missed;
    public final FlowableReplay$ReplaySubscriber<T> parent;
    public final AtomicLong totalRequested = new AtomicLong();

    public FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber<T> flowableReplay$ReplaySubscriber, c<? super T> cVar) {
        this.parent = flowableReplay$ReplaySubscriber;
        this.child = cVar;
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.remove(this);
            this.parent.manageRequests();
            this.index = null;
        }
    }

    public <U> U index() {
        return this.index;
    }

    public boolean isDisposed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j11) {
        return io.reactivex.rxjava3.internal.util.b.f(this, j11);
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11) && io.reactivex.rxjava3.internal.util.b.b(this, j11) != Long.MIN_VALUE) {
            io.reactivex.rxjava3.internal.util.b.a(this.totalRequested, j11);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }
    }
}
