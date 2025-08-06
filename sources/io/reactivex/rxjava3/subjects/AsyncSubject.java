package io.reactivex.rxjava3.subjects;

import h00.k;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import o00.a;

public final class AsyncSubject<T> extends Subject<T> {

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject<T> parent;

        public AsyncDisposable(k<? super T> kVar, AsyncSubject<T> asyncSubject) {
            super(kVar);
        }

        public void dispose() {
            if (super.tryDispose()) {
                throw null;
            }
        }

        public void onComplete() {
            if (!isDisposed()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                a.n(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }
}
