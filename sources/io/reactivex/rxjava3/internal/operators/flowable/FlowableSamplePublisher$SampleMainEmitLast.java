package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;

final class FlowableSamplePublisher$SampleMainEmitLast<T> extends FlowableSamplePublisher$SamplePublisherSubscriber<T> {
    private static final long serialVersionUID = -3029755663834015785L;
    public volatile boolean done;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableSamplePublisher$SampleMainEmitLast(c<? super T> cVar, b<?> bVar) {
        super(cVar, bVar);
    }

    public void completion() {
        this.done = true;
        if (this.wip.getAndIncrement() == 0) {
            emit();
            this.downstream.onComplete();
        }
    }

    public void run() {
        if (this.wip.getAndIncrement() == 0) {
            do {
                boolean z11 = this.done;
                emit();
                if (z11) {
                    this.downstream.onComplete();
                    return;
                }
            } while (this.wip.decrementAndGet() != 0);
        }
    }
}
