package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = 2026620218879969836L;
    public final f<? super T> downstream;
    public final h<? super Throwable, ? extends g<? extends T>> resumeFunction;

    public static final class a<T> implements f<T> {

        /* renamed from: b  reason: collision with root package name */
        public final f<? super T> f55541b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<b> f55542c;

        public a(f<? super T> fVar, AtomicReference<b> atomicReference) {
            this.f55541b = fVar;
            this.f55542c = atomicReference;
        }

        public void onComplete() {
            this.f55541b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f55541b.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f55542c, bVar);
        }

        public void onSuccess(T t11) {
            this.f55541b.onSuccess(t11);
        }
    }

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(f<? super T> fVar, h<? super Throwable, ? extends g<? extends T>> hVar) {
        this.downstream = fVar;
        this.resumeFunction = hVar;
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
        try {
            Object apply = this.resumeFunction.apply(th2);
            Objects.requireNonNull(apply, "The resumeFunction returned a null MaybeSource");
            g gVar = (g) apply;
            DisposableHelper.replace(this, (b) null);
            gVar.a(new a(this.downstream, this));
        } catch (Throwable th3) {
            io.reactivex.rxjava3.exceptions.a.b(th3);
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
