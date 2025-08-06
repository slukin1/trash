package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleCache<T> extends Single<T> implements m<T> {

    public static final class CacheDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 7514387411091976596L;
        public final m<? super T> downstream;
        public final SingleCache<T> parent;

        public CacheDisposable(m<? super T> mVar, SingleCache<T> singleCache) {
            this.downstream = mVar;
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
