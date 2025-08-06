package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import z20.c;

abstract class FlowableCreate$NoOverflowBaseAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4127754106204442833L;

    public FlowableCreate$NoOverflowBaseAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    public final void onNext(T t11) {
        if (!isCancelled()) {
            if (t11 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
            } else if (get() != 0) {
                this.downstream.onNext(t11);
                b.e(this, 1);
            } else {
                onOverflow();
            }
        }
    }

    public abstract void onOverflow();
}
