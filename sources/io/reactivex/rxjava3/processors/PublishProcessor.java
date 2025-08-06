package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;
import z20.d;

public final class PublishProcessor<T> extends FlowableProcessor<T> {

    public static final class PublishSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = 3562861878281475070L;
        public final c<? super T> downstream;
        public final PublishProcessor<T> parent;

        public PublishSubscription(c<? super T> cVar, PublishProcessor<T> publishProcessor) {
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

        public boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th2);
            } else {
                a.n(th2);
            }
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MIN_VALUE) {
                if (j11 != 0) {
                    this.downstream.onNext(t11);
                    b.f(this, 1);
                    return;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                b.b(this, j11);
            }
        }
    }
}
