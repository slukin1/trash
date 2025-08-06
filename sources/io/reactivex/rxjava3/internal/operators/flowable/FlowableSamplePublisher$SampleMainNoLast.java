package io.reactivex.rxjava3.internal.operators.flowable;

import z20.b;
import z20.c;

final class FlowableSamplePublisher$SampleMainNoLast<T> extends FlowableSamplePublisher$SamplePublisherSubscriber<T> {
    private static final long serialVersionUID = -3029755663834015785L;

    public FlowableSamplePublisher$SampleMainNoLast(c<? super T> cVar, b<?> bVar) {
        super(cVar, bVar);
    }

    public void completion() {
        this.downstream.onComplete();
    }

    public void run() {
        emit();
    }
}
