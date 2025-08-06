package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.processors.FlowableProcessor;
import z20.c;
import z20.d;

final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(c<? super T> cVar, FlowableProcessor<Throwable> flowableProcessor, d dVar) {
        super(cVar, flowableProcessor, dVar);
    }

    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        again(th2);
    }
}
