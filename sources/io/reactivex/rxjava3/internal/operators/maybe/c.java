package io.reactivex.rxjava3.internal.operators.maybe;

import k00.f;

public interface c<T> extends f<T> {
    int consumerIndex();

    void drop();

    T peek();

    T poll();

    int producerIndex();
}
