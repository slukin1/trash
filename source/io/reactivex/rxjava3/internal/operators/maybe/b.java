package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.m;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class b<R> implements m<R> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<io.reactivex.rxjava3.disposables.b> f55551b;

    /* renamed from: c  reason: collision with root package name */
    public final f<? super R> f55552c;

    public b(AtomicReference<io.reactivex.rxjava3.disposables.b> atomicReference, f<? super R> fVar) {
        this.f55551b = atomicReference;
        this.f55552c = fVar;
    }

    public void onError(Throwable th2) {
        this.f55552c.onError(th2);
    }

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        DisposableHelper.replace(this.f55551b, bVar);
    }

    public void onSuccess(R r11) {
        this.f55552c.onSuccess(r11);
    }
}
