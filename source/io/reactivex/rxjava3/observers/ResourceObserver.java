package io.reactivex.rxjava3.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceObserver<T> implements k<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55729b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final ListCompositeDisposable f55730c = new ListCompositeDisposable();

    public void a() {
    }

    public final void dispose() {
        if (DisposableHelper.dispose(this.f55729b)) {
            this.f55730c.dispose();
        }
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f55729b.get());
    }

    public final void onSubscribe(b bVar) {
        if (d.c(this.f55729b, bVar, getClass())) {
            a();
        }
    }
}
