package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;

public final class g<T> implements k<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSampleWithObservable$SampleMainObserver<T> f55572b;

    public g(ObservableSampleWithObservable$SampleMainObserver<T> observableSampleWithObservable$SampleMainObserver) {
        this.f55572b = observableSampleWithObservable$SampleMainObserver;
    }

    public void onComplete() {
        this.f55572b.complete();
    }

    public void onError(Throwable th2) {
        this.f55572b.error(th2);
    }

    public void onNext(Object obj) {
        this.f55572b.run();
    }

    public void onSubscribe(b bVar) {
        this.f55572b.setOther(bVar);
    }
}
