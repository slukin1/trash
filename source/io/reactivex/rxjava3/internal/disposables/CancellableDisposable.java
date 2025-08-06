package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import j00.f;
import java.util.concurrent.atomic.AtomicReference;

public final class CancellableDisposable extends AtomicReference<f> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    public void dispose() {
        f fVar;
        if (get() != null && (fVar = (f) getAndSet((Object) null)) != null) {
            try {
                fVar.cancel();
            } catch (Throwable th2) {
                a.b(th2);
                o00.a.n(th2);
            }
        }
    }

    public boolean isDisposed() {
        return get() == null;
    }
}
