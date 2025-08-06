package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;

final class ObservableSampleTimed$SampleTimedNoLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    public ObservableSampleTimed$SampleTimedNoLast(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(kVar, j11, timeUnit, scheduler);
    }

    public void complete() {
        this.downstream.onComplete();
    }

    public void run() {
        emit();
    }
}
