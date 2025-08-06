package io.reactivex.rxjava3.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements k<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55723b = new AtomicReference<>();

    public void a() {
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f55723b);
    }

    public final boolean isDisposed() {
        return this.f55723b.get() == DisposableHelper.DISPOSED;
    }

    public final void onSubscribe(b bVar) {
        if (d.c(this.f55723b, bVar, getClass())) {
            a();
        }
    }
}
