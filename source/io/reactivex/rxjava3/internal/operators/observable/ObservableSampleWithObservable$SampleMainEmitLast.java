package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableSampleWithObservable$SampleMainEmitLast<T> extends ObservableSampleWithObservable$SampleMainObserver<T> {
    private static final long serialVersionUID = -3029755663834015785L;
    public volatile boolean done;
    public final AtomicInteger wip = new AtomicInteger();

    public ObservableSampleWithObservable$SampleMainEmitLast(k<? super T> kVar, j<?> jVar) {
        super(kVar, jVar);
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
