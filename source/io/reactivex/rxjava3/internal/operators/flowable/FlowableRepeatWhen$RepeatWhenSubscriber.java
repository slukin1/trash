package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.processors.FlowableProcessor;
import z20.c;
import z20.d;

final class FlowableRepeatWhen$RepeatWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Object> {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRepeatWhen$RepeatWhenSubscriber(c<? super T> cVar, FlowableProcessor<Object> flowableProcessor, d dVar) {
        super(cVar, flowableProcessor, dVar);
    }

    public void onComplete() {
        again(0);
    }

    public void onError(Throwable th2) {
        this.receiver.cancel();
        this.downstream.onError(th2);
    }
}
