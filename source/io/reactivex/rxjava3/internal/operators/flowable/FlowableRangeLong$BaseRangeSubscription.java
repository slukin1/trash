package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;

abstract class FlowableRangeLong$BaseRangeSubscription extends BasicQueueSubscription<Long> {
    private static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final long end;
    public long index;

    public FlowableRangeLong$BaseRangeSubscription(long j11, long j12) {
        this.index = j11;
        this.end = j12;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.index = this.end;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        return this.index == this.end;
    }

    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11) && b.a(this, j11) == 0) {
            if (j11 == Long.MAX_VALUE) {
                fastPath();
            } else {
                slowPath(j11);
            }
        }
    }

    public final int requestFusion(int i11) {
        return i11 & 1;
    }

    public abstract void slowPath(long j11);

    public final Long poll() {
        long j11 = this.index;
        if (j11 == this.end) {
            return null;
        }
        this.index = 1 + j11;
        return Long.valueOf(j11);
    }
}
