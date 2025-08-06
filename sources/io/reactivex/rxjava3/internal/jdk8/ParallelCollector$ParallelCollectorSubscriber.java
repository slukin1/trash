package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import z20.c;

final class ParallelCollector$ParallelCollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> {
    private static final long serialVersionUID = -5370107872170712765L;
    public final AtomicReference<ParallelCollector$SlotPair<A>> current = new AtomicReference<>();
    public final AtomicThrowable error = new AtomicThrowable();
    public final Function<A, R> finisher;
    public final AtomicInteger remaining = new AtomicInteger();
    public final ParallelCollector$ParallelCollectorInnerSubscriber<T, A, R>[] subscribers;

    public ParallelCollector$ParallelCollectorSubscriber(c<? super R> cVar, int i11, Collector<T, A, R> collector) {
        super(cVar);
        this.finisher = collector.finisher();
        ParallelCollector$ParallelCollectorInnerSubscriber<T, A, R>[] parallelCollector$ParallelCollectorInnerSubscriberArr = new ParallelCollector$ParallelCollectorInnerSubscriber[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            parallelCollector$ParallelCollectorInnerSubscriberArr[i12] = new ParallelCollector$ParallelCollectorInnerSubscriber<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
        }
        this.subscribers = parallelCollector$ParallelCollectorInnerSubscriberArr;
        this.remaining.lazySet(i11);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [A, T] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A> addValue(A r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r0 = r3.current
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = (io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair) r0
            r1 = 0
            if (r0 != 0) goto L_0x0019
            io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = new io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair
            r0.<init>()
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.current
            boolean r2 = r2.compareAndSet(r1, r0)
            if (r2 != 0) goto L_0x0019
            goto L_0x0000
        L_0x0019:
            int r2 = r0.tryAcquireSlot()
            if (r2 >= 0) goto L_0x0025
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.current
            r2.compareAndSet(r0, r1)
            goto L_0x0000
        L_0x0025:
            if (r2 != 0) goto L_0x002a
            r0.first = r4
            goto L_0x002c
        L_0x002a:
            r0.second = r4
        L_0x002c:
            boolean r4 = r0.releaseSlot()
            if (r4 == 0) goto L_0x0038
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r4 = r3.current
            r4.compareAndSet(r0, r1)
            return r0
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelCollector$ParallelCollectorSubscriber.addValue(java.lang.Object):io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair");
    }

    public void cancel() {
        for (ParallelCollector$ParallelCollectorInnerSubscriber<T, A, R> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void innerComplete(A a11, BinaryOperator<A> binaryOperator) {
        while (true) {
            ParallelCollector$SlotPair addValue = addValue(a11);
            if (addValue == null) {
                break;
            }
            try {
                a11 = binaryOperator.apply(addValue.first, addValue.second);
            } catch (Throwable th2) {
                a.b(th2);
                innerError(th2);
                return;
            }
        }
        if (this.remaining.decrementAndGet() == 0) {
            ParallelCollector$SlotPair parallelCollector$SlotPair = this.current.get();
            this.current.lazySet((Object) null);
            try {
                R apply = this.finisher.apply(parallelCollector$SlotPair.first);
                Objects.requireNonNull(apply, "The finisher returned a null value");
                complete(apply);
            } catch (Throwable th3) {
                a.b(th3);
                innerError(th3);
            }
        }
    }

    public void innerError(Throwable th2) {
        if (this.error.compareAndSet((Object) null, th2)) {
            cancel();
            this.downstream.onError(th2);
        } else if (th2 != this.error.get()) {
            o00.a.n(th2);
        }
    }
}
