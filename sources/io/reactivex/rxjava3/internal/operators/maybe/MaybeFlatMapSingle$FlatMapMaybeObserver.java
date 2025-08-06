package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeFlatMapSingle$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = 4827726964688405508L;
    public final f<? super R> downstream;
    public final h<? super T, ? extends o<? extends R>> mapper;

    public MaybeFlatMapSingle$FlatMapMaybeObserver(f<? super R> fVar, h<? super T, ? extends o<? extends R>> hVar) {
        this.downstream = fVar;
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

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            o oVar = (o) apply;
            if (!isDisposed()) {
                oVar.a(new b(this, this.downstream));
            }
        } catch (Throwable th2) {
            a.b(th2);
            onError(th2);
        }
    }
}
