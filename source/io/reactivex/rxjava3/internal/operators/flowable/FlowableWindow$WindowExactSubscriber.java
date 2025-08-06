package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import z20.c;
import z20.d;

final class FlowableWindow$WindowExactSubscriber<T> extends AtomicInteger implements e<T>, d, Runnable {
    private static final long serialVersionUID = -2365647875069161133L;
    public final int bufferSize;
    public final c<? super Flowable<T>> downstream;
    public long index;
    public final AtomicBoolean once = new AtomicBoolean();
    public final long size;
    public d upstream;
    public UnicastProcessor<T> window;

    public FlowableWindow$WindowExactSubscriber(c<? super Flowable<T>> cVar, long j11, int i11) {
        super(1);
        this.downstream = cVar;
        this.size = j11;
        this.bufferSize = i11;
    }

    public void cancel() {
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    public void onComplete() {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(th2);
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        s sVar;
        long j11 = this.index;
        UnicastProcessor<T> unicastProcessor = this.window;
        if (j11 == 0) {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.o(this.bufferSize, this);
            this.window = unicastProcessor;
            sVar = new s(unicastProcessor);
            this.downstream.onNext(sVar);
        } else {
            sVar = null;
        }
        long j12 = j11 + 1;
        unicastProcessor.onNext(t11);
        if (j12 == this.size) {
            this.index = 0;
            this.window = null;
            unicastProcessor.onComplete();
        } else {
            this.index = j12;
        }
        if (sVar != null && sVar.m()) {
            sVar.f55528c.onComplete();
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.upstream.request(b.d(this.size, j11));
        }
    }

    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
