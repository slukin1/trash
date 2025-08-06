package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class k<T> implements h00.k<T> {

    /* renamed from: b  reason: collision with root package name */
    public final h00.k<? super T> f55583b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<b> f55584c;

    public k(h00.k<? super T> kVar, AtomicReference<b> atomicReference) {
        this.f55583b = kVar;
        this.f55584c = atomicReference;
    }

    public void onComplete() {
        this.f55583b.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55583b.onError(th2);
    }

    public void onNext(T t11) {
        this.f55583b.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this.f55584c, bVar);
    }
}
