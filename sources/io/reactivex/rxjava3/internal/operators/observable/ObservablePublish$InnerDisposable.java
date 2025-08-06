package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicReference;

final class ObservablePublish$InnerDisposable<T> extends AtomicReference<ObservablePublish$PublishConnection<T>> implements b {
    private static final long serialVersionUID = 7463222674719692880L;
    public final k<? super T> downstream;

    public ObservablePublish$InnerDisposable(k<? super T> kVar, ObservablePublish$PublishConnection<T> observablePublish$PublishConnection) {
        this.downstream = kVar;
        lazySet(observablePublish$PublishConnection);
    }

    public void dispose() {
        ObservablePublish$PublishConnection observablePublish$PublishConnection = (ObservablePublish$PublishConnection) getAndSet((Object) null);
        if (observablePublish$PublishConnection != null) {
            observablePublish$PublishConnection.remove(this);
        }
    }

    public boolean isDisposed() {
        return get() == null;
    }
}
