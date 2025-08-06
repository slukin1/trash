package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;

abstract class FlowableRange$BaseRangeSubscription extends BasicQueueSubscription<Integer> {
    private static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final int end;
    public int index;

    public FlowableRange$BaseRangeSubscription(int i11, int i12) {
        this.index = i11;
        this.end = i12;
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

    public final Integer poll() {
        int i11 = this.index;
        if (i11 == this.end) {
            return null;
        }
        this.index = i11 + 1;
        return Integer.valueOf(i11);
    }
}
