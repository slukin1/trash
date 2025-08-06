package io.reactivex.rxjava3.observers;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceMaybeObserver<T> implements f<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55727b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final ListCompositeDisposable f55728c = new ListCompositeDisposable();

    public void a() {
    }

    public final void dispose() {
        if (DisposableHelper.dispose(this.f55727b)) {
            this.f55728c.dispose();
        }
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f55727b.get());
    }

    public final void onSubscribe(b bVar) {
        if (d.c(this.f55727b, bVar, getClass())) {
            a();
        }
    }
}
