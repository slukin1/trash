package io.reactivex.rxjava3.internal.operators.flowable;

public interface c<T> {
    void innerComplete();

    void innerError(Throwable th2);

    void innerNext(T t11);
}
