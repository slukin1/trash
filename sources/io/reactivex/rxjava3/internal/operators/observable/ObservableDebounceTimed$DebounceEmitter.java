package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<b> implements Runnable, b {
    private static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once = new AtomicBoolean();
    public final c<T> parent;
    public final T value;

    public ObservableDebounceTimed$DebounceEmitter(T t11, long j11, c<T> cVar) {
        this.value = t11;
        this.idx = j11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void run() {
        if (this.once.compareAndSet(false, true)) {
            throw null;
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
