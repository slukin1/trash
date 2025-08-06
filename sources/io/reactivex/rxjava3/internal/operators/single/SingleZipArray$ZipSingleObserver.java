package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class SingleZipArray$ZipSingleObserver<T> extends AtomicReference<b> implements m<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final SingleZipArray$ZipCoordinator<T, ?> parent;

    public SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator<T, ?> singleZipArray$ZipCoordinator, int i11) {
        this.parent = singleZipArray$ZipCoordinator;
        this.index = i11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(th2, this.index);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        this.parent.innerSuccess(t11, this.index);
    }
}
