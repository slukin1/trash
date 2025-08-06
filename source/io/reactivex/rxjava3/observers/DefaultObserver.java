package io.reactivex.rxjava3.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.util.d;

public abstract class DefaultObserver<T> implements k<T> {

    /* renamed from: b  reason: collision with root package name */
    public b f55720b;

    public void a() {
    }

    public final void onSubscribe(b bVar) {
        if (d.e(this.f55720b, bVar, getClass())) {
            this.f55720b = bVar;
            a();
        }
    }
}
