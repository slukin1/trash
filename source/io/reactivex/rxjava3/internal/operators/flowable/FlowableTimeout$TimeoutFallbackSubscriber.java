package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.b;
import z20.c;
import z20.d;

final class FlowableTimeout$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements e<T>, n {
    private static final long serialVersionUID = 3764492702657003550L;
    public long consumed;
    public final c<? super T> downstream;
    public b<? extends T> fallback;
    public final AtomicLong index;
    public final h<? super T, ? extends b<?>> itemTimeoutIndicator;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public FlowableTimeout$TimeoutFallbackSubscriber(c<? super T> cVar, h<? super T, ? extends b<?>> hVar, b<? extends T> bVar) {
        super(true);
        this.downstream = cVar;
        this.itemTimeoutIndicator = hVar;
        this.fallback = bVar;
        this.index = new AtomicLong();
    }

    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.task.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.task.dispose();
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        long j11 = this.index.get();
        if (j11 != Long.MAX_VALUE) {
            long j12 = j11 + 1;
            if (this.index.compareAndSet(j11, j12)) {
                io.reactivex.rxjava3.disposables.b bVar = (io.reactivex.rxjava3.disposables.b) this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.consumed++;
                this.downstream.onNext(t11);
                try {
                    Object apply = this.itemTimeoutIndicator.apply(t11);
                    Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                    b bVar2 = (b) apply;
                    FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(j12, this);
                    if (this.task.replace(flowableTimeout$TimeoutConsumer)) {
                        bVar2.subscribe(flowableTimeout$TimeoutConsumer);
                    }
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    this.upstream.get().cancel();
                    this.index.getAndSet(Long.MAX_VALUE);
                    this.downstream.onError(th2);
                }
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            setSubscription(dVar);
        }
    }

    public void onTimeout(long j11) {
        if (this.index.compareAndSet(j11, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            b<? extends T> bVar = this.fallback;
            this.fallback = null;
            long j12 = this.consumed;
            if (j12 != 0) {
                produced(j12);
            }
            bVar.subscribe(new o(this.downstream, this));
        }
    }

    public void onTimeoutError(long j11, Throwable th2) {
        if (this.index.compareAndSet(j11, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th2);
            return;
        }
        a.n(th2);
    }

    public void startFirstTimeout(b<?> bVar) {
        if (bVar != null) {
            FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(0, this);
            if (this.task.replace(flowableTimeout$TimeoutConsumer)) {
                bVar.subscribe(flowableTimeout$TimeoutConsumer);
            }
        }
    }
}
