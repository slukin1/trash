package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

final class MaybeToObservable$MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements f<T> {
    private static final long serialVersionUID = 7603343402964826922L;
    public b upstream;

    public MaybeToObservable$MaybeToObservableObserver(k<? super T> kVar) {
        super(kVar);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onComplete() {
        complete();
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
