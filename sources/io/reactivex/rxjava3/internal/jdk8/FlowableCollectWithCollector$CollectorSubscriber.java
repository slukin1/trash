package io.reactivex.rxjava3.internal.jdk8;

import h00.e;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import z20.c;
import z20.d;

final class FlowableCollectWithCollector$CollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> implements e<T> {
    private static final long serialVersionUID = -229544830565448758L;
    public final BiConsumer<A, T> accumulator;
    public A container;
    public boolean done;
    public final Function<A, R> finisher;
    public d upstream;

    public FlowableCollectWithCollector$CollectorSubscriber(c<? super R> cVar, A a11, BiConsumer<A, T> biConsumer, Function<A, R> function) {
        super(cVar);
        this.container = a11;
        this.accumulator = biConsumer;
        this.finisher = function;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            A a11 = this.container;
            this.container = null;
            try {
                R apply = this.finisher.apply(a11);
                Objects.requireNonNull(apply, "The finisher returned a null value");
                complete(apply);
            } catch (Throwable th2) {
                a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.done = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        this.container = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                this.accumulator.accept(this.container, t11);
            } catch (Throwable th2) {
                a.b(th2);
                this.upstream.cancel();
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
