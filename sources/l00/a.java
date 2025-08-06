package l00;

import io.reactivex.rxjava3.internal.observers.InnerQueuedObserver;

public interface a<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(InnerQueuedObserver<T> innerQueuedObserver, Throwable th2);

    void innerNext(InnerQueuedObserver<T> innerQueuedObserver, T t11);
}
