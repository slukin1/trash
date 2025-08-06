package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class SingleDelayWithSingle$OtherObserver<T, U> extends AtomicReference<b> implements m<U>, b {
    private static final long serialVersionUID = -8565274649390031272L;
    public final m<? super T> downstream;
    public final o<T> source;

    public SingleDelayWithSingle$OtherObserver(m<? super T> mVar, o<T> oVar) {
        this.downstream = mVar;
        this.source = oVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(U u11) {
        this.source.a(new l00.b(this, this.downstream));
    }
}
