package io.reactivex.rxjava3.internal.operators.single;

import h00.k;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

final class SingleToObservable$SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements m<T> {
    private static final long serialVersionUID = 3786543492451018833L;
    public b upstream;

    public SingleToObservable$SingleToObservableObserver(k<? super T> kVar) {
        super(kVar);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onError(Throwable th2) {
        error(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        complete(t11);
    }
}
