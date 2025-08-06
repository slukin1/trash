package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import o00.a;
import z20.d;

final class FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> extends AtomicReference<d> implements e<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;
    public final long index;
    public final FlowableSwitchMap$SwitchMapSubscriber<T, R> parent;
    public volatile f<R> queue;

    public FlowableSwitchMap$SwitchMapInnerSubscriber(FlowableSwitchMap$SwitchMapSubscriber<T, R> flowableSwitchMap$SwitchMapSubscriber, long j11, int i11) {
        this.parent = flowableSwitchMap$SwitchMapSubscriber;
        this.index = j11;
        this.bufferSize = i11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> flowableSwitchMap$SwitchMapSubscriber = this.parent;
        if (this.index == flowableSwitchMap$SwitchMapSubscriber.unique) {
            this.done = true;
            flowableSwitchMap$SwitchMapSubscriber.drain();
        }
    }

    public void onError(Throwable th2) {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> flowableSwitchMap$SwitchMapSubscriber = this.parent;
        if (this.index != flowableSwitchMap$SwitchMapSubscriber.unique || !flowableSwitchMap$SwitchMapSubscriber.errors.tryAddThrowable(th2)) {
            a.n(th2);
            return;
        }
        if (!flowableSwitchMap$SwitchMapSubscriber.delayErrors) {
            flowableSwitchMap$SwitchMapSubscriber.upstream.cancel();
            flowableSwitchMap$SwitchMapSubscriber.done = true;
        }
        this.done = true;
        flowableSwitchMap$SwitchMapSubscriber.drain();
    }

    public void onNext(R r11) {
        FlowableSwitchMap$SwitchMapSubscriber<T, R> flowableSwitchMap$SwitchMapSubscriber = this.parent;
        if (this.index != flowableSwitchMap$SwitchMapSubscriber.unique) {
            return;
        }
        if (this.fusionMode != 0 || this.queue.offer(r11)) {
            flowableSwitchMap$SwitchMapSubscriber.drain();
        } else {
            onError(new MissingBackpressureException("Queue full?!"));
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
                    dVar.request((long) this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            dVar.request((long) this.bufferSize);
        }
    }

    public void request(long j11) {
        if (this.fusionMode != 1) {
            ((d) get()).request(j11);
        }
    }
}
