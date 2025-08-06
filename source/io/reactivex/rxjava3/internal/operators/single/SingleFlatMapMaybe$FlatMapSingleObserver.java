package io.reactivex.rxjava3.internal.operators.single;

import h00.f;
import h00.g;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class SingleFlatMapMaybe$FlatMapSingleObserver<T, R> extends AtomicReference<b> implements m<T>, b {
    private static final long serialVersionUID = -5843758257109742742L;
    public final f<? super R> downstream;
    public final h<? super T, ? extends g<? extends R>> mapper;

    public SingleFlatMapMaybe$FlatMapSingleObserver(f<? super R> fVar, h<? super T, ? extends g<? extends R>> hVar) {
        this.downstream = fVar;
        this.mapper = hVar;
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

    public void onSuccess(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            g gVar = (g) apply;
            if (!isDisposed()) {
                gVar.a(new a(this, this.downstream));
            }
        } catch (Throwable th2) {
            a.b(th2);
            onError(th2);
        }
    }
}
