package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableInterval$IntervalSubscriber extends AtomicLong implements d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public long count;
    public final c<? super Long> downstream;
    public final AtomicReference<b> resource = new AtomicReference<>();

    public FlowableInterval$IntervalSubscriber(c<? super Long> cVar) {
        this.downstream = cVar;
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
        if (this.resource.get() == DisposableHelper.DISPOSED) {
            return;
        }
        if (get() != 0) {
            c<? super Long> cVar = this.downstream;
            long j11 = this.count;
            this.count = j11 + 1;
            cVar.onNext(Long.valueOf(j11));
            io.reactivex.rxjava3.internal.util.b.e(this, 1);
            return;
        }
        c<? super Long> cVar2 = this.downstream;
        cVar2.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
        DisposableHelper.dispose(this.resource);
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this.resource, bVar);
    }
}
