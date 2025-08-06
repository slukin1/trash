package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class SingleFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<b> implements m<U> {
    private static final long serialVersionUID = -2897979525538174559L;
    public final m<? super R> downstream;
    public final c<? super T, ? super U, ? extends R> resultSelector;
    public T value;

    public SingleFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(m<? super R> mVar, c<? super T, ? super U, ? extends R> cVar) {
        this.downstream = mVar;
        this.resultSelector = cVar;
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(U u11) {
        T t11 = this.value;
        this.value = null;
        try {
            Object apply = this.resultSelector.apply(t11, u11);
            Objects.requireNonNull(apply, "The resultSelector returned a null value");
            this.downstream.onSuccess(apply);
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }
}
