package io.reactivex.rxjava3.internal.operators.single;

import h00.a;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class SingleDelayWithCompletable$OtherObserver<T> extends AtomicReference<b> implements a, b {
    private static final long serialVersionUID = -8565274649390031272L;
    public final m<? super T> downstream;
    public final o<T> source;

    public SingleDelayWithCompletable$OtherObserver(m<? super T> mVar, o<T> oVar) {
        this.downstream = mVar;
        this.source = oVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.source.a(new l00.b(this, this.downstream));
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
