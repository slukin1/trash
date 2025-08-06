package io.reactivex.rxjava3.internal.operators.observable;

public interface f<T> {
    void complete();

    void error(Throwable th2);

    void next(T t11);

    void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable);
}
