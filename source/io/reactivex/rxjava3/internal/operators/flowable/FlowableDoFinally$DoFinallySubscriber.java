package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.a;
import k00.d;
import z20.c;

final class FlowableDoFinally$DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements e<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    public final c<? super T> downstream;
    public final a onFinally;

    /* renamed from: qs  reason: collision with root package name */
    public d<T> f55483qs;
    public boolean syncFused;
    public z20.d upstream;

    public FlowableDoFinally$DoFinallySubscriber(c<? super T> cVar, a aVar) {
        this.downstream = cVar;
        this.onFinally = aVar;
    }

    public void cancel() {
        this.upstream.cancel();
        runFinally();
    }

    public void clear() {
        this.f55483qs.clear();
    }

    public boolean isEmpty() {
        return this.f55483qs.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        runFinally();
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(z20.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof d) {
                this.f55483qs = (d) dVar;
            }
            this.downstream.onSubscribe(this);
        }
    }

    public T poll() throws Throwable {
        T poll = this.f55483qs.poll();
        if (poll == null && this.syncFused) {
            runFinally();
        }
        return poll;
    }

    public void request(long j11) {
        this.upstream.request(j11);
    }

    public int requestFusion(int i11) {
        d<T> dVar = this.f55483qs;
        boolean z11 = false;
        if (dVar == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = dVar.requestFusion(i11);
        if (requestFusion != 0) {
            if (requestFusion == 1) {
                z11 = true;
            }
            this.syncFused = z11;
        }
        return requestFusion;
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                o00.a.n(th2);
            }
        }
    }
}
