package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableAndThenCompletable$SourceObserver extends AtomicReference<b> implements a, b {
    private static final long serialVersionUID = -4101678820158072998L;
    public final a actualObserver;
    public final h00.b next;

    public CompletableAndThenCompletable$SourceObserver(a aVar, h00.b bVar) {
        this.actualObserver = aVar;
        this.next = bVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.next.a(new a(this, this.actualObserver));
    }

    public void onError(Throwable th2) {
        this.actualObserver.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actualObserver.onSubscribe(this);
        }
    }
}
