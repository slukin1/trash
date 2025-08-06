package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.d;

final class FlowableZip$ZipSubscriber<T, R> extends AtomicReference<d> implements e<T>, d {
    private static final long serialVersionUID = -4627193790118206028L;
    public volatile boolean done;
    public final int limit;
    public final FlowableZip$ZipCoordinator<T, R> parent;
    public final int prefetch;
    public long produced;
    public f<T> queue;
    public int sourceMode;

    public FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator<T, R> flowableZip$ZipCoordinator, int i11) {
        this.parent = flowableZip$ZipCoordinator;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable th2) {
        this.parent.error(this, th2);
    }

    public void onNext(T t11) {
        if (this.sourceMode != 2) {
            this.queue.offer(t11);
        }
        this.parent.drain();
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    dVar.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            dVar.request((long) this.prefetch);
        }
    }

    public void request(long j11) {
        if (this.sourceMode != 1) {
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
