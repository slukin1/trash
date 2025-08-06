package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.d;

final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<d> implements e<U>, b {
    private static final long serialVersionUID = -4606175640614850599L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;

    /* renamed from: id  reason: collision with root package name */
    public final long f55484id;
    public final int limit;
    public final FlowableFlatMap$MergeSubscriber<T, U> parent;
    public long produced;
    public volatile f<U> queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber, int i11, long j11) {
        this.f55484id = j11;
        this.parent = flowableFlatMap$MergeSubscriber;
        this.bufferSize = i11;
        this.limit = i11 >> 2;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable th2) {
        lazySet(SubscriptionHelper.CANCELLED);
        this.parent.innerError(this, th2);
    }

    public void onNext(U u11) {
        if (this.fusionMode != 2) {
            this.parent.tryEmit(u11, this);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                }
            }
            dVar.request((long) this.bufferSize);
        }
    }

    public void requestMore(long j11) {
        if (this.fusionMode != 1) {
            long j12 = this.produced + j11;
            if (j12 >= ((long) this.limit)) {
                this.produced = 0;
                ((d) get()).request(j12);
                return;
            }
            this.produced = j12;
        }
    }
}
