package io.reactivex.rxjava3.observers;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceSingleObserver<T> implements m<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55731b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final ListCompositeDisposable f55732c = new ListCompositeDisposable();

    public void a() {
    }

    public final void dispose() {
        if (DisposableHelper.dispose(this.f55731b)) {
            this.f55732c.dispose();
        }
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f55731b.get());
    }

    public final void onSubscribe(b bVar) {
        if (d.c(this.f55731b, bVar, getClass())) {
            a();
        }
    }
}
