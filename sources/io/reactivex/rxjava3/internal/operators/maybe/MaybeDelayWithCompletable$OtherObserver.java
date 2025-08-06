package io.reactivex.rxjava3.internal.operators.maybe;

import h00.a;
import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeDelayWithCompletable$OtherObserver<T> extends AtomicReference<b> implements a, b {
    private static final long serialVersionUID = 703409937383992161L;
    public final f<? super T> downstream;
    public final g<T> source;

    public MaybeDelayWithCompletable$OtherObserver(f<? super T> fVar, g<T> gVar) {
        this.downstream = fVar;
        this.source = gVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.source.a(new a(this, this.downstream));
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }
}
