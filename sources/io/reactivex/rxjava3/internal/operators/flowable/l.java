package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import z20.d;

public final class l<T> implements e<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final FlowableSamplePublisher$SamplePublisherSubscriber<T> f55521b;

    public l(FlowableSamplePublisher$SamplePublisherSubscriber<T> flowableSamplePublisher$SamplePublisherSubscriber) {
        this.f55521b = flowableSamplePublisher$SamplePublisherSubscriber;
    }

    public void onComplete() {
        this.f55521b.complete();
    }

    public void onError(Throwable th2) {
        this.f55521b.error(th2);
    }

    public void onNext(Object obj) {
        this.f55521b.run();
    }

    public void onSubscribe(d dVar) {
        this.f55521b.setOther(dVar);
    }
}
