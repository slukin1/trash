package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableResumeNext$ResumeNextObserver extends AtomicReference<b> implements a, b {
    private static final long serialVersionUID = 5018523762564524046L;
    public final a downstream;
    public final h<? super Throwable, ? extends h00.b> errorMapper;
    public boolean once;

    public CompletableResumeNext$ResumeNextObserver(a aVar, h<? super Throwable, ? extends h00.b> hVar) {
        this.downstream = aVar;
        this.errorMapper = hVar;
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
        if (this.once) {
            this.downstream.onError(th2);
            return;
        }
        this.once = true;
        try {
            Object apply = this.errorMapper.apply(th2);
            Objects.requireNonNull(apply, "The errorMapper returned a null CompletableSource");
            ((h00.b) apply).a(this);
        } catch (Throwable th3) {
            io.reactivex.rxjava3.exceptions.a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
