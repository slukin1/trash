package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.b;
import z20.c;
import z20.d;

final class FlowableSwitchMap$SwitchMapSubscriber<T, R> extends AtomicInteger implements e<T>, d {
    public static final FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    public final AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final c<? super R> downstream;
    public final AtomicThrowable errors;
    public final h<? super T, ? extends b<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public volatile long unique;
    public d upstream;

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber = new FlowableSwitchMap$SwitchMapInnerSubscriber<>((FlowableSwitchMap$SwitchMapSubscriber) null, -1, 1);
        CANCELLED = flowableSwitchMap$SwitchMapInnerSubscriber;
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i11, boolean z11) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.bufferSize = i11;
        this.delayErrors = z11;
        this.errors = new AtomicThrowable();
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }
    }

    public void disposeInner() {
        AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> atomicReference = this.active;
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber = CANCELLED;
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> andSet = atomicReference.getAndSet(flowableSwitchMap$SwitchMapInnerSubscriber);
        if (andSet != flowableSwitchMap$SwitchMapInnerSubscriber && andSet != null) {
            andSet.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
        r15 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r17 = this;
            r1 = r17
            int r0 = r17.getAndIncrement()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            z20.c<? super R> r2 = r1.downstream
            r4 = 1
        L_0x000c:
            boolean r0 = r1.cancelled
            if (r0 == 0) goto L_0x0011
            return
        L_0x0011:
            boolean r0 = r1.done
            if (r0 == 0) goto L_0x0046
            boolean r0 = r1.delayErrors
            if (r0 == 0) goto L_0x0027
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0046
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            r0.tryTerminateConsumer((z20.c<?>) r2)
            return
        L_0x0027:
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x003a
            r17.disposeInner()
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            r0.tryTerminateConsumer((z20.c<?>) r2)
            return
        L_0x003a:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0046
            r2.onComplete()
            return
        L_0x0046:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            java.lang.Object r0 = r0.get()
            r5 = r0
            io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber) r5
            r6 = 0
            if (r5 == 0) goto L_0x0056
            k00.f<R> r0 = r5.queue
            r7 = r0
            goto L_0x0057
        L_0x0056:
            r7 = r6
        L_0x0057:
            if (r7 == 0) goto L_0x011d
            java.util.concurrent.atomic.AtomicLong r0 = r1.requested
            long r8 = r0.get()
            r10 = 0
            r12 = r10
        L_0x0062:
            int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r14 == 0) goto L_0x00c7
            boolean r0 = r1.cancelled
            if (r0 == 0) goto L_0x006b
            return
        L_0x006b:
            boolean r0 = r5.done
            java.lang.Object r16 = r7.poll()     // Catch:{ all -> 0x0074 }
            r3 = r16
            goto L_0x0086
        L_0x0074:
            r0 = move-exception
            r16 = r0
            io.reactivex.rxjava3.exceptions.a.b(r16)
            r5.cancel()
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            r3 = r16
            r0.tryAddThrowableOrReport(r3)
            r3 = r6
            r0 = 1
        L_0x0086:
            if (r3 != 0) goto L_0x008b
            r16 = 1
            goto L_0x008d
        L_0x008b:
            r16 = 0
        L_0x008d:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r15 = r1.active
            java.lang.Object r15 = r15.get()
            if (r5 == r15) goto L_0x0097
        L_0x0095:
            r15 = 1
            goto L_0x00c8
        L_0x0097:
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r1.delayErrors
            if (r0 != 0) goto L_0x00b5
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x00ad
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            r0.tryTerminateConsumer((z20.c<?>) r2)
            return
        L_0x00ad:
            if (r16 == 0) goto L_0x00bd
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r5, r6)
            goto L_0x0095
        L_0x00b5:
            if (r16 == 0) goto L_0x00bd
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r5, r6)
            goto L_0x0095
        L_0x00bd:
            if (r16 == 0) goto L_0x00c0
            goto L_0x00c7
        L_0x00c0:
            r2.onNext(r3)
            r14 = 1
            long r12 = r12 + r14
            goto L_0x0062
        L_0x00c7:
            r15 = 0
        L_0x00c8:
            if (r14 != 0) goto L_0x00ff
            boolean r0 = r5.done
            if (r0 == 0) goto L_0x00ff
            boolean r0 = r1.delayErrors
            if (r0 != 0) goto L_0x00f2
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x00e5
            r17.disposeInner()
            io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
            r0.tryTerminateConsumer((z20.c<?>) r2)
            return
        L_0x00e5:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x00ff
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r5, r6)
            goto L_0x000c
        L_0x00f2:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x00ff
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r5, r6)
            goto L_0x000c
        L_0x00ff:
            int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0119
            boolean r0 = r1.cancelled
            if (r0 != 0) goto L_0x0119
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0116
            java.util.concurrent.atomic.AtomicLong r0 = r1.requested
            long r6 = -r12
            r0.addAndGet(r6)
        L_0x0116:
            r5.request(r12)
        L_0x0119:
            if (r15 == 0) goto L_0x011d
            goto L_0x000c
        L_0x011d:
            int r0 = -r4
            int r4 = r1.addAndGet(r0)
            if (r4 != 0) goto L_0x000c
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber.drain():void");
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done || !this.errors.tryAddThrowable(th2)) {
            a.n(th2);
            return;
        }
        if (!this.delayErrors) {
            disposeInner();
        }
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber;
        if (!this.done) {
            long j11 = this.unique + 1;
            this.unique = j11;
            FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.get();
            if (flowableSwitchMap$SwitchMapInnerSubscriber2 != null) {
                flowableSwitchMap$SwitchMapInnerSubscriber2.cancel();
            }
            try {
                Object apply = this.mapper.apply(t11);
                Objects.requireNonNull(apply, "The publisher returned is null");
                b bVar = (b) apply;
                FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber3 = new FlowableSwitchMap$SwitchMapInnerSubscriber(this, j11, this.bufferSize);
                do {
                    flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
                    if (flowableSwitchMap$SwitchMapInnerSubscriber == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, flowableSwitchMap$SwitchMapInnerSubscriber3));
                bVar.subscribe(flowableSwitchMap$SwitchMapInnerSubscriber3);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
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
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            if (this.unique == 0) {
                this.upstream.request(Long.MAX_VALUE);
            } else {
                drain();
            }
        }
    }
}
