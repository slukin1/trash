package io.reactivex.rxjava3.internal.operators.observable;

import h00.a;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableMergeWithCompletable$MergeWithObserver<T> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = -4592979584110982903L;
    public final k<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<b> mainDisposable = new AtomicReference<>();
    public volatile boolean mainDone;
    public volatile boolean otherDone;
    public final OtherObserver otherObserver = new OtherObserver(this);

    public static final class OtherObserver extends AtomicReference<b> implements a {
        private static final long serialVersionUID = -2935427570954647017L;
        public final ObservableMergeWithCompletable$MergeWithObserver<?> parent;

        public OtherObserver(ObservableMergeWithCompletable$MergeWithObserver<?> observableMergeWithCompletable$MergeWithObserver) {
            this.parent = observableMergeWithCompletable$MergeWithObserver;
        }

        public void onComplete() {
            this.parent.otherComplete();
        }

        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableMergeWithCompletable$MergeWithObserver(k<? super T> kVar) {
        this.downstream = kVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
        this.errors.tryTerminateAndReport();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone) {
            e.a(this.downstream, this, this.errors);
        }
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.otherObserver);
        e.c(this.downstream, th2, this, this.errors);
    }

    public void onNext(T t11) {
        e.e(this.downstream, t11, this, this.errors);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.mainDisposable, bVar);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone) {
            e.a(this.downstream, this, this.errors);
        }
    }

    public void otherError(Throwable th2) {
        DisposableHelper.dispose(this.mainDisposable);
        e.c(this.downstream, th2, this, this.errors);
    }
}
