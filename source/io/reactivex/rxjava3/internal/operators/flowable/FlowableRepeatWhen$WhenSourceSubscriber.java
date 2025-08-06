package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import z20.c;
import z20.d;

abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements e<T> {
    private static final long serialVersionUID = -5604623027276966720L;
    public final c<? super T> downstream;
    public final FlowableProcessor<U> processor;
    private long produced;
    public final d receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(c<? super T> cVar, FlowableProcessor<U> flowableProcessor, d dVar) {
        super(false);
        this.downstream = cVar;
        this.processor = flowableProcessor;
        this.receiver = dVar;
    }

    public final void again(U u11) {
        setSubscription(EmptySubscription.INSTANCE);
        long j11 = this.produced;
        if (j11 != 0) {
            this.produced = 0;
            produced(j11);
        }
        this.receiver.request(1);
        this.processor.onNext(u11);
    }

    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable th2);

    public final void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(t11);
    }

    public final void onSubscribe(d dVar) {
        setSubscription(dVar);
    }
}
