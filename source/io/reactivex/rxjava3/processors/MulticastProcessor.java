package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    public static final class MulticastSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = -363282618957264509L;
        public final c<? super T> downstream;
        public long emitted;
        public final MulticastProcessor<T> parent;

        public MulticastSubscription(c<? super T> cVar, MulticastProcessor<T> multicastProcessor) {
            this.downstream = cVar;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                throw null;
            }
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t11);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                long b11 = b.b(this, j11);
                if (b11 != Long.MIN_VALUE && b11 != Long.MAX_VALUE) {
                    throw null;
                }
            }
        }
    }
}
