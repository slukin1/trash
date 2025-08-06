package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.c;
import java.util.Objects;
import o00.a;
import z20.d;

final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    public R accumulator;
    public boolean done;
    public final c<R, ? super T, R> reducer;

    public ParallelReduce$ParallelReduceSubscriber(z20.c<? super R> cVar, R r11, c<R, ? super T, R> cVar2) {
        super(cVar);
        this.accumulator = r11;
        this.reducer = cVar2;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            R r11 = this.accumulator;
            this.accumulator = null;
            complete(r11);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                R apply = this.reducer.apply(this.accumulator, t11);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                this.accumulator = apply;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
