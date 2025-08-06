package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.Objects;

abstract class FlowableFromArray$BaseArraySubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    public final T[] array;
    public volatile boolean cancelled;
    public int index;

    public FlowableFromArray$BaseArraySubscription(T[] tArr) {
        this.array = tArr;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.index = this.array.length;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        return this.index == this.array.length;
    }

    public final T poll() {
        int i11 = this.index;
        T[] tArr = this.array;
        if (i11 == tArr.length) {
            return null;
        }
        this.index = i11 + 1;
        T t11 = tArr[i11];
        Objects.requireNonNull(t11, "array element is null");
        return t11;
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
}
