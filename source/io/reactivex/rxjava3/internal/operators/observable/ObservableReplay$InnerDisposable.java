package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableReplay$InnerDisposable<T> extends AtomicInteger implements b {
    private static final long serialVersionUID = 2728361546769921047L;
    public volatile boolean cancelled;
    public final k<? super T> child;
    public Object index;
    public final ObservableReplay$ReplayObserver<T> parent;

    public ObservableReplay$InnerDisposable(ObservableReplay$ReplayObserver<T> observableReplay$ReplayObserver, k<? super T> kVar) {
        this.parent = observableReplay$ReplayObserver;
        this.child = kVar;
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.parent.remove(this);
            this.index = null;
        }
    }

    public <U> U index() {
        return this.index;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}
