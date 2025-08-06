package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import z20.c;

final class FlowableCreate$MissingEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 3776720187248809713L;

    public FlowableCreate$MissingEmitter(c<? super T> cVar) {
        super(cVar);
    }

    public void onNext(T t11) {
        long j11;
        if (!isCancelled()) {
            if (t11 != null) {
                this.downstream.onNext(t11);
                do {
                    j11 = get();
                    if (j11 == 0 || compareAndSet(j11, j11 - 1)) {
                        return;
                    }
                    j11 = get();
                    return;
                } while (compareAndSet(j11, j11 - 1));
                return;
            }
            onError(ExceptionHelper.b("onNext called with a null value."));
        }
    }
}
