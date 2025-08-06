package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;

final class ObservableSampleWithObservable$SampleMainNoLast<T> extends ObservableSampleWithObservable$SampleMainObserver<T> {
    private static final long serialVersionUID = -3029755663834015785L;

    public ObservableSampleWithObservable$SampleMainNoLast(k<? super T> kVar, j<?> jVar) {
        super(kVar, jVar);
    }

    public void completion() {
        this.downstream.onComplete();
    }

    public void run() {
        emit();
    }
}
