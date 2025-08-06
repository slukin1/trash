package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class SingleFlatMapNotification$FlatMapSingleObserver<T, R> extends AtomicReference<b> implements m<T>, b {
    private static final long serialVersionUID = 4375739915521278546L;
    public final m<? super R> downstream;
    public final h<? super Throwable, ? extends o<? extends R>> onErrorMapper;
    public final h<? super T, ? extends o<? extends R>> onSuccessMapper;
    public b upstream;

    public final class a implements m<R> {
        public a() {
        }

        public void onError(Throwable th2) {
            SingleFlatMapNotification$FlatMapSingleObserver.this.downstream.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(SingleFlatMapNotification$FlatMapSingleObserver.this, bVar);
        }

        public void onSuccess(R r11) {
            SingleFlatMapNotification$FlatMapSingleObserver.this.downstream.onSuccess(r11);
        }
    }

    public SingleFlatMapNotification$FlatMapSingleObserver(m<? super R> mVar, h<? super T, ? extends o<? extends R>> hVar, h<? super Throwable, ? extends o<? extends R>> hVar2) {
        this.downstream = mVar;
        this.onSuccessMapper = hVar;
        this.onErrorMapper = hVar2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.onErrorMapper.apply(th2);
            Objects.requireNonNull(apply, "The onErrorMapper returned a null SingleSource");
            o oVar = (o) apply;
            if (!isDisposed()) {
                oVar.a(new a());
            }
        } catch (Throwable th3) {
            io.reactivex.rxjava3.exceptions.a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        try {
            Object apply = this.onSuccessMapper.apply(t11);
            Objects.requireNonNull(apply, "The onSuccessMapper returned a null SingleSource");
            o oVar = (o) apply;
            if (!isDisposed()) {
                oVar.a(new a());
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.downstream.onError(th2);
        }
    }
}
