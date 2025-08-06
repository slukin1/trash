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

final class FlowableWindow$WindowSkipSubscriber<T> extends AtomicInteger implements e<T>, d, Runnable {
    private static final long serialVersionUID = -8792836352386833856L;
    public final int bufferSize;
    public final c<? super Flowable<T>> downstream;
    public final AtomicBoolean firstRequest = new AtomicBoolean();
    public long index;
    public final AtomicBoolean once = new AtomicBoolean();
    public final long size;
    public final long skip;
    public d upstream;
    public UnicastProcessor<T> window;

    public FlowableWindow$WindowSkipSubscriber(c<? super Flowable<T>> cVar, long j11, long j12, int i11) {
        super(1);
        this.downstream = cVar;
        this.size = j11;
        this.skip = j12;
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
        if (unicastProcessor != null) {
            unicastProcessor.onNext(t11);
        }
        if (j12 == this.size) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        if (j12 == this.skip) {
            this.index = 0;
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
        if (!SubscriptionHelper.validate(j11)) {
            return;
        }
        if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
            this.upstream.request(b.d(this.skip, j11));
            return;
        }
        this.upstream.request(b.c(b.d(this.size, j11), b.d(this.skip - this.size, j11 - 1)));
    }

    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
