package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableTakeUntilCompletable$TakeUntilMainObserver extends AtomicReference<b> implements a, b {
    private static final long serialVersionUID = 3533011714830024923L;
    public final a downstream;
    public final AtomicBoolean once = new AtomicBoolean();
    public final OtherObserver other = new OtherObserver(this);

    public static final class OtherObserver extends AtomicReference<b> implements a {
        private static final long serialVersionUID = 5176264485428790318L;
        public final CompletableTakeUntilCompletable$TakeUntilMainObserver parent;

        public OtherObserver(CompletableTakeUntilCompletable$TakeUntilMainObserver completableTakeUntilCompletable$TakeUntilMainObserver) {
            this.parent = completableTakeUntilCompletable$TakeUntilMainObserver;
        }

        public void onComplete() {
            this.parent.innerComplete();
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public CompletableTakeUntilCompletable$TakeUntilMainObserver(a aVar) {
        this.downstream = aVar;
    }

    public void dispose() {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
        }
    }

    public void innerComplete() {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }
    }

    public void innerError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th2);
            return;
        }
        o00.a.n(th2);
    }

    public boolean isDisposed() {
        return this.once.get();
    }

    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
            return;
        }
        o00.a.n(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
