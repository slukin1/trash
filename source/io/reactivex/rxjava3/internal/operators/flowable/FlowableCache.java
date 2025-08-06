package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

public final class FlowableCache<T> extends a<T, T> implements e<T> {

    public static final class CacheSubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 6770240836423125754L;
        public final c<? super T> downstream;
        public long index;
        public a<T> node;
        public int offset;
        public final FlowableCache<T> parent;
        public final AtomicLong requested;

        public CacheSubscription(c<? super T> cVar, FlowableCache<T> flowableCache) {
            this.downstream = cVar;
            throw null;
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                throw null;
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                b.b(this.requested, j11);
                throw null;
            }
        }
    }

    public static final class a<T> {
    }
}
