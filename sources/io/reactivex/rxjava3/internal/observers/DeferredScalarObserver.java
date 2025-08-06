package io.reactivex.rxjava3.internal.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements k<T> {
    private static final long serialVersionUID = -266195175408988651L;
    public b upstream;

    public DeferredScalarObserver(k<? super R> kVar) {
        super(kVar);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onComplete() {
        T t11 = this.value;
        if (t11 != null) {
            this.value = null;
            complete(t11);
            return;
        }
        complete();
    }

    public void onError(Throwable th2) {
        this.value = null;
        error(th2);
    }

    public abstract /* synthetic */ void onNext(T t11);

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
