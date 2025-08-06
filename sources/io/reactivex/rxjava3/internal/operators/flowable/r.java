package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import o00.a;

public final class r<T, B> extends DisposableSubscriber<B> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> f55526c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55527d;

    public r(FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> flowableWindowBoundary$WindowBoundaryMainSubscriber) {
        this.f55526c = flowableWindowBoundary$WindowBoundaryMainSubscriber;
    }

    public void onComplete() {
        if (!this.f55527d) {
            this.f55527d = true;
            this.f55526c.innerComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f55527d) {
            a.n(th2);
            return;
        }
        this.f55527d = true;
        this.f55526c.innerError(th2);
    }

    public void onNext(B b11) {
        if (!this.f55527d) {
            this.f55526c.innerNext();
        }
    }
}
