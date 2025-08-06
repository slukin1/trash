package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class a implements h00.a {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55474b;

    /* renamed from: c  reason: collision with root package name */
    public final h00.a f55475c;

    public a(AtomicReference<b> atomicReference, h00.a aVar) {
        this.f55474b = atomicReference;
        this.f55475c = aVar;
    }

    public void onComplete() {
        this.f55475c.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55475c.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this.f55474b, bVar);
    }
}
