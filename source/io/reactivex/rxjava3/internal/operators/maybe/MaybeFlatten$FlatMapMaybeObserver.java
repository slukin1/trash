package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = 4375739915521278546L;
    public final f<? super R> downstream;
    public final h<? super T, ? extends g<? extends R>> mapper;
    public b upstream;

    public final class a implements f<R> {
        public a() {
        }

        public void onComplete() {
            MaybeFlatten$FlatMapMaybeObserver.this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            MaybeFlatten$FlatMapMaybeObserver.this.downstream.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(MaybeFlatten$FlatMapMaybeObserver.this, bVar);
        }

        public void onSuccess(R r11) {
            MaybeFlatten$FlatMapMaybeObserver.this.downstream.onSuccess(r11);
        }
    }

    public MaybeFlatten$FlatMapMaybeObserver(f<? super R> fVar, h<? super T, ? extends g<? extends R>> hVar) {
        this.downstream = fVar;
        this.mapper = hVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
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
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            g gVar = (g) apply;
            if (!isDisposed()) {
                gVar.a(new a());
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.downstream.onError(th2);
        }
    }
}
