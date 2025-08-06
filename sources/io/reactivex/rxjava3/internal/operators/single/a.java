package io.reactivex.rxjava3.internal.operators.single;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class a<R> implements f<R> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55607b;

    /* renamed from: c  reason: collision with root package name */
    public final f<? super R> f55608c;

    public a(AtomicReference<b> atomicReference, f<? super R> fVar) {
        this.f55607b = atomicReference;
        this.f55608c = fVar;
    }

    public void onComplete() {
        this.f55608c.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55608c.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this.f55607b, bVar);
    }

    public void onSuccess(R r11) {
        this.f55608c.onSuccess(r11);
    }
}
