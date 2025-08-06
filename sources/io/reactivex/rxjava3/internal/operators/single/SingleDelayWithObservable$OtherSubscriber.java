package io.reactivex.rxjava3.internal.operators.single;

import h00.k;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class SingleDelayWithObservable$OtherSubscriber<T, U> extends AtomicReference<b> implements k<U>, b {
    private static final long serialVersionUID = -8565274649390031272L;
    public boolean done;
    public final m<? super T> downstream;
    public final o<T> source;

    public SingleDelayWithObservable$OtherSubscriber(m<? super T> mVar, o<T> oVar) {
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
        if (!this.done) {
            this.done = true;
            this.source.a(new l00.b(this, this.downstream));
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    public void onNext(U u11) {
        ((b) get()).dispose();
        onComplete();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }
}
