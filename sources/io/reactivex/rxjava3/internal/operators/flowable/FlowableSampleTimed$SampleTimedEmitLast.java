package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import z20.c;

final class FlowableSampleTimed$SampleTimedEmitLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    public final AtomicInteger wip = new AtomicInteger(1);

    public FlowableSampleTimed$SampleTimedEmitLast(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(cVar, j11, timeUnit, scheduler);
    }

    public void complete() {
        emit();
        if (this.wip.decrementAndGet() == 0) {
            this.downstream.onComplete();
        }
    }

    public void run() {
        if (this.wip.incrementAndGet() == 2) {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }
    }
}
