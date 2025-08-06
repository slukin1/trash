package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> implements f<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55549b;

    /* renamed from: c  reason: collision with root package name */
    public final f<? super T> f55550c;

    public a(AtomicReference<b> atomicReference, f<? super T> fVar) {
        this.f55549b = atomicReference;
        this.f55550c = fVar;
    }

    public void onComplete() {
        this.f55550c.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55550c.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this.f55549b, bVar);
    }

    public void onSuccess(T t11) {
        this.f55550c.onSuccess(t11);
    }
}
