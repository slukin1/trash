package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableWithLatestFrom$WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements k<T>, b {
    private static final long serialVersionUID = -312246233408980075L;
    public final c<? super T, ? super U, ? extends R> combiner;
    public final k<? super R> downstream;
    public final AtomicReference<b> other = new AtomicReference<>();
    public final AtomicReference<b> upstream = new AtomicReference<>();

    public ObservableWithLatestFrom$WithLatestFromObserver(k<? super R> kVar, c<? super T, ? super U, ? extends R> cVar) {
        this.downstream = kVar;
        this.combiner = cVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        Object obj = get();
        if (obj != null) {
            try {
                Object apply = this.combiner.apply(t11, obj);
                Objects.requireNonNull(apply, "The combiner returned a null value");
                this.downstream.onNext(apply);
            } catch (Throwable th2) {
                a.b(th2);
                dispose();
                this.downstream.onError(th2);
            }
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void otherError(Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(th2);
    }

    public boolean setOther(b bVar) {
        return DisposableHelper.setOnce(this.other, bVar);
    }
}
