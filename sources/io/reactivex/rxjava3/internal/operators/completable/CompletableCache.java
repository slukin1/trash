package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableCache extends Completable implements a {

    public final class InnerCompletableCache extends AtomicBoolean implements b {
        private static final long serialVersionUID = 8943152917179642732L;
        public final a downstream;
        public final /* synthetic */ CompletableCache this$0;

        public InnerCompletableCache(CompletableCache completableCache, a aVar) {
            this.downstream = aVar;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }
}
