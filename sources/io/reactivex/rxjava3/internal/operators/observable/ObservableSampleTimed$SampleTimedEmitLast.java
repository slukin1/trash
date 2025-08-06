package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableSampleTimed$SampleTimedEmitLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    public final AtomicInteger wip = new AtomicInteger(1);

    public ObservableSampleTimed$SampleTimedEmitLast(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(kVar, j11, timeUnit, scheduler);
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
