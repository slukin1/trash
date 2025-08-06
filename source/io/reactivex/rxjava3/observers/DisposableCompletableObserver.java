package io.reactivex.rxjava3.observers;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableCompletableObserver implements a, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55721b = new AtomicReference<>();

    public void a() {
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f55721b);
    }

    public final boolean isDisposed() {
        return this.f55721b.get() == DisposableHelper.DISPOSED;
    }

    public final void onSubscribe(b bVar) {
        if (d.c(this.f55721b, bVar, getClass())) {
            a();
        }
    }
}
