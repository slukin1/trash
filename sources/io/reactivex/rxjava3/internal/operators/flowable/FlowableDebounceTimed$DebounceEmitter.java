package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class FlowableDebounceTimed$DebounceEmitter<T> extends AtomicReference<b> implements Runnable, b {
    private static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once = new AtomicBoolean();
    public final FlowableDebounceTimed$DebounceTimedSubscriber<T> parent;
    public final T value;

    public FlowableDebounceTimed$DebounceEmitter(T t11, long j11, FlowableDebounceTimed$DebounceTimedSubscriber<T> flowableDebounceTimed$DebounceTimedSubscriber) {
        this.value = t11;
        this.idx = j11;
        this.parent = flowableDebounceTimed$DebounceTimedSubscriber;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void emit() {
        if (this.once.compareAndSet(false, true)) {
            this.parent.emit(this.idx, this.value, this);
        }
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void run() {
        emit();
    }

    public void setResource(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
