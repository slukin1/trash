package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.Iterator;
import java.util.Objects;

abstract class FlowableFromIterable$BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public Iterator<? extends T> iterator;
    public boolean once;

    public FlowableFromIterable$BaseRangeSubscription(Iterator<? extends T> it2) {
        this.iterator = it2;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.iterator = null;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        Iterator<? extends T> it2 = this.iterator;
        if (it2 == null) {
            return true;
        }
        if (!this.once || it2.hasNext()) {
            return false;
        }
        clear();
        return true;
    }

    public final T poll() {
        Iterator<? extends T> it2 = this.iterator;
        if (it2 == null) {
            return null;
        }
        if (!this.once) {
            this.once = true;
        } else if (!it2.hasNext()) {
            return null;
        }
        T next = this.iterator.next();
        Objects.requireNonNull(next, "Iterator.next() returned a null value");
        return next;
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
