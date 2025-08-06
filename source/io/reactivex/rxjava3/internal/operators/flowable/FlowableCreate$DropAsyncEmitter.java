package io.reactivex.rxjava3.internal.operators.flowable;

import z20.c;

final class FlowableCreate$DropAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 8360058422307496563L;

    public FlowableCreate$DropAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    public void onOverflow() {
    }
}
