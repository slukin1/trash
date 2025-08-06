package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public long count;
    public final c<? super Long> downstream;
    public final long end;
    public final AtomicReference<b> resource = new AtomicReference<>();

    public FlowableIntervalRange$IntervalRangeSubscriber(c<? super Long> cVar, long j11, long j12) {
        this.downstream = cVar;
        this.count = j11;
        this.end = j12;
    }

    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this, j11);
        }
    }

    public void run() {
        b bVar = this.resource.get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            long j11 = get();
            if (j11 != 0) {
                long j12 = this.count;
                this.downstream.onNext(Long.valueOf(j12));
                if (j12 == this.end) {
                    if (this.resource.get() != disposableHelper) {
                        this.downstream.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                this.count = j12 + 1;
                if (j11 != Long.MAX_VALUE) {
                    decrementAndGet();
                    return;
                }
                return;
            }
            c<? super Long> cVar = this.downstream;
            cVar.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this.resource, bVar);
    }
}
