package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableGroupJoin$LeftRightEndObserver extends AtomicReference<b> implements k<Object>, b {
    private static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final e parent;

    public ObservableGroupJoin$LeftRightEndObserver(e eVar, boolean z11, int i11) {
        this.parent = eVar;
        this.isLeft = z11;
        this.index = i11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.parent.innerClose(this.isLeft, this);
    }

    public void onError(Throwable th2) {
        this.parent.innerCloseError(th2);
    }

    public void onNext(Object obj) {
        if (DisposableHelper.dispose(this)) {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
