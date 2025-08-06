package io.reactivex.rxjava3.internal.operators.flowable;

import h00.h;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import o00.a;
import z20.c;

final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, h<T>> {
    private static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(c<? super h<T>> cVar) {
        super(cVar);
    }

    public void onComplete() {
        complete(h.a());
    }

    public void onError(Throwable th2) {
        complete(h.b(th2));
    }

    public void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(h.c(t11));
    }

    public void onDrop(h<T> hVar) {
        if (hVar.e()) {
            a.n(hVar.d());
        }
    }
}
