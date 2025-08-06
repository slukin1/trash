package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import o00.a;
import z20.c;

public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        public final AsyncProcessor<T> parent;

        public AsyncSubscription(c<? super T> cVar, AsyncProcessor<T> asyncProcessor) {
            super(cVar);
        }

        public void cancel() {
            if (super.tryCancel()) {
                throw null;
            }
        }

        public void onComplete() {
            if (!isCancelled()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isCancelled()) {
                a.n(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }
}
