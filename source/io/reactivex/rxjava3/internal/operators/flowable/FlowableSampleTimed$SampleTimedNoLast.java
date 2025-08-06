package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import z20.c;

final class FlowableSampleTimed$SampleTimedNoLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    public FlowableSampleTimed$SampleTimedNoLast(c<? super T> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(cVar, j11, timeUnit, scheduler);
    }

    public void complete() {
        this.downstream.onComplete();
    }

    public void run() {
        emit();
    }
}
