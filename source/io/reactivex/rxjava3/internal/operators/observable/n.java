package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.observers.DisposableObserver;
import o00.a;

public final class n<T, B> extends DisposableObserver<B> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> f55587c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55588d;

    public n(ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> observableWindowBoundary$WindowBoundaryMainObserver) {
        this.f55587c = observableWindowBoundary$WindowBoundaryMainObserver;
    }

    public void onComplete() {
        if (!this.f55588d) {
            this.f55588d = true;
            this.f55587c.innerComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f55588d) {
            a.n(th2);
            return;
        }
        this.f55588d = true;
        this.f55587c.innerError(th2);
    }

    public void onNext(B b11) {
        if (!this.f55588d) {
            this.f55587c.innerNext();
        }
    }
}
