package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableCache<T> extends a<T, T> implements k<T> {

    public static final class CacheDisposable<T> extends AtomicInteger implements b {
        private static final long serialVersionUID = 6770240836423125754L;
        public volatile boolean disposed;
        public final k<? super T> downstream;
        public long index;
        public a<T> node;
        public int offset;
        public final ObservableCache<T> parent;

        public CacheDisposable(k<? super T> kVar, ObservableCache<T> observableCache) {
            this.downstream = kVar;
            throw null;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                throw null;
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static final class a<T> {
    }
}
