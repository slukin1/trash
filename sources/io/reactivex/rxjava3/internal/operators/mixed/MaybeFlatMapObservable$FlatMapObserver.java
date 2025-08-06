package io.reactivex.rxjava3.internal.operators.mixed;

import h00.f;
import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeFlatMapObservable$FlatMapObserver<T, R> extends AtomicReference<b> implements k<R>, f<T>, b {
    private static final long serialVersionUID = -8948264376121066672L;
    public final k<? super R> downstream;
    public final h<? super T, ? extends j<? extends R>> mapper;

    public MaybeFlatMapObservable$FlatMapObserver(k<? super R> kVar, h<? super T, ? extends j<? extends R>> hVar) {
        this.downstream = kVar;
        this.mapper = hVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(R r11) {
        this.downstream.onNext(r11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this, bVar);
    }

    public void onSuccess(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            j jVar = (j) apply;
            if (!isDisposed()) {
                jVar.subscribe(this);
            }
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }
}
