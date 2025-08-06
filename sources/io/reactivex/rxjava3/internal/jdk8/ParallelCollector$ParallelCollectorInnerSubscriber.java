package io.reactivex.rxjava3.internal.jdk8;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import o00.a;
import z20.d;

final class ParallelCollector$ParallelCollectorInnerSubscriber<T, A, R> extends AtomicReference<d> implements e<T> {
    private static final long serialVersionUID = -7954444275102466525L;
    public final BiConsumer<A, T> accumulator;
    public final BinaryOperator<A> combiner;
    public A container;
    public boolean done;
    public final ParallelCollector$ParallelCollectorSubscriber<T, A, R> parent;

    public ParallelCollector$ParallelCollectorInnerSubscriber(ParallelCollector$ParallelCollectorSubscriber<T, A, R> parallelCollector$ParallelCollectorSubscriber, A a11, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator) {
        this.parent = parallelCollector$ParallelCollectorSubscriber;
        this.accumulator = biConsumer;
        this.combiner = binaryOperator;
        this.container = a11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        if (!this.done) {
            A a11 = this.container;
            this.container = null;
            this.done = true;
            this.parent.innerComplete(a11, this.combiner);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.container = null;
        this.done = true;
        this.parent.innerError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                this.accumulator.accept(this.container, t11);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                ((d) get()).cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
