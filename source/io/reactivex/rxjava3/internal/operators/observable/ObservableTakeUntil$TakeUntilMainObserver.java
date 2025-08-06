package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableTakeUntil$TakeUntilMainObserver<T, U> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = 1418547743690811973L;
    public final k<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final ObservableTakeUntil$TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
    public final AtomicReference<b> upstream = new AtomicReference<>();

    public final class OtherObserver extends AtomicReference<b> implements k<U> {
        private static final long serialVersionUID = -8693423678067375039L;

        public OtherObserver() {
        }

        public void onComplete() {
            ObservableTakeUntil$TakeUntilMainObserver.this.otherComplete();
        }

        public void onError(Throwable th2) {
            ObservableTakeUntil$TakeUntilMainObserver.this.otherError(th2);
        }

        public void onNext(U u11) {
            DisposableHelper.dispose(this);
            ObservableTakeUntil$TakeUntilMainObserver.this.otherComplete();
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableTakeUntil$TakeUntilMainObserver(k<? super T> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.otherObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.otherObserver);
        e.a(this.downstream, this, this.error);
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.otherObserver);
        e.c(this.downstream, th2, this, this.error);
    }

    public void onNext(T t11) {
        e.e(this.downstream, t11, this, this.error);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void otherComplete() {
        DisposableHelper.dispose(this.upstream);
        e.a(this.downstream, this, this.error);
    }

    public void otherError(Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        e.c(this.downstream, th2, this, this.error);
    }
}
