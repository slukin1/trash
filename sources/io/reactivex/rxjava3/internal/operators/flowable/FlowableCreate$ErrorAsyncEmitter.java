package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import z20.c;

final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
