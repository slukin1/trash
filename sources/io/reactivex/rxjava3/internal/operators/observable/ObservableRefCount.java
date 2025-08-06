package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

public final class ObservableRefCount<T> extends Observable<T> {

    public static final class RefConnection extends AtomicReference<b> implements Runnable, g<b> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final ObservableRefCount<?> parent;
        public long subscriberCount;
        public b timer;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
        }

        public void run() {
            throw null;
        }

        public void accept(b bVar) {
            DisposableHelper.replace(this, bVar);
            throw null;
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements k<T>, b {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final k<? super T> downstream;
        public final ObservableRefCount<T> parent;
        public b upstream;

        public RefCountObserver(k<? super T> kVar, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = kVar;
            this.connection = refConnection;
        }

        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public void onError(Throwable th2) {
            if (!compareAndSet(false, true)) {
                a.n(th2);
                return;
            }
            throw null;
        }

        public void onNext(T t11) {
            this.downstream.onNext(t11);
        }

        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
