package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableCombineLatest$CombinerObserver<T, R> extends AtomicReference<b> implements k<T> {
    private static final long serialVersionUID = -4823716997131257941L;
    public final int index;
    public final ObservableCombineLatest$LatestCoordinator<T, R> parent;

    public ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator<T, R> observableCombineLatest$LatestCoordinator, int i11) {
        this.parent = observableCombineLatest$LatestCoordinator;
        this.index = i11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this.index, th2);
    }

    public void onNext(T t11) {
        this.parent.innerNext(this.index, t11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
