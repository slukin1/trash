package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class SingleResumeNext$ResumeMainSingleObserver<T> extends AtomicReference<b> implements m<T>, b {
    private static final long serialVersionUID = -5314538511045349925L;
    public final m<? super T> downstream;
    public final h<? super Throwable, ? extends o<? extends T>> nextFunction;

    public SingleResumeNext$ResumeMainSingleObserver(m<? super T> mVar, h<? super Throwable, ? extends o<? extends T>> hVar) {
        this.downstream = mVar;
        this.nextFunction = hVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.nextFunction.apply(th2);
            Objects.requireNonNull(apply, "The nextFunction returned a null SingleSource.");
            ((o) apply).a(new l00.b(this, this.downstream));
        } catch (Throwable th3) {
            a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }
}
