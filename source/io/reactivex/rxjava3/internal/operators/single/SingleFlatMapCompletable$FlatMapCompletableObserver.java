package io.reactivex.rxjava3.internal.operators.single;

import h00.a;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class SingleFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<b> implements m<T>, a, b {
    private static final long serialVersionUID = -2177128922851101253L;
    public final a downstream;
    public final h<? super T, ? extends h00.b> mapper;

    public SingleFlatMapCompletable$FlatMapCompletableObserver(a aVar, h<? super T, ? extends h00.b> hVar) {
        this.downstream = aVar;
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
        DisposableHelper.replace(this, bVar);
    }

    public void onSuccess(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
            h00.b bVar = (h00.b) apply;
            if (!isDisposed()) {
                bVar.a(this);
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            onError(th2);
        }
    }
}
