package io.reactivex.rxjava3.subjects;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import o00.a;

public final class PublishSubject<T> extends Subject<T> {

    public static final class PublishDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        public final k<? super T> downstream;
        public final PublishSubject<T> parent;

        public PublishDisposable(k<? super T> kVar, PublishSubject<T> publishSubject) {
            this.downstream = kVar;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                a.n(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.downstream.onNext(t11);
            }
        }
    }
}
