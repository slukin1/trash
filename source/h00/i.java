package h00;

import io.reactivex.rxjava3.disposables.b;
import j00.f;

public interface i<T> extends c<T> {
    boolean isDisposed();

    void setCancellable(f fVar);

    void setDisposable(b bVar);

    boolean tryOnError(Throwable th2);
}
