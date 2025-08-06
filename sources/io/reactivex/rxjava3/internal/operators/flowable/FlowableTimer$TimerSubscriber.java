package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableTimer$TimerSubscriber extends AtomicReference<b> implements d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public final c<? super Long> downstream;
    public volatile boolean requested;

    public FlowableTimer$TimerSubscriber(c<? super Long> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.requested = true;
        }
    }

    public void run() {
        if (get() == DisposableHelper.DISPOSED) {
            return;
        }
        if (this.requested) {
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
            return;
        }
        lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
    }

    public void setResource(b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
