package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<b> implements m<T>, b {
    private static final long serialVersionUID = 3258103020495908596L;
    public final m<? super R> downstream;
    public final h<? super T, ? extends o<? extends R>> mapper;

    public static final class a<R> implements m<R> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<b> f55600b;

        /* renamed from: c  reason: collision with root package name */
        public final m<? super R> f55601c;

        public a(AtomicReference<b> atomicReference, m<? super R> mVar) {
            this.f55600b = atomicReference;
            this.f55601c = mVar;
        }

        public void onError(Throwable th2) {
            this.f55601c.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this.f55600b, bVar);
        }

        public void onSuccess(R r11) {
            this.f55601c.onSuccess(r11);
        }
    }

    public SingleFlatMap$SingleFlatMapCallback(m<? super R> mVar, h<? super T, ? extends o<? extends R>> hVar) {
        this.downstream = mVar;
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
            Objects.requireNonNull(apply, "The single returned by the mapper is null");
            o oVar = (o) apply;
            if (!isDisposed()) {
                oVar.a(new a(this, this.downstream));
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.downstream.onError(th2);
        }
    }
}
