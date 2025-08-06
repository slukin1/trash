package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable implements b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<b> f55437b = new AtomicReference<>();

    public void dispose() {
        DisposableHelper.dispose(this.f55437b);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f55437b.get());
    }
}
