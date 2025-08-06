package io.reactivex.rxjava3.internal.jdk8;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.b;
import j00.h;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import k00.f;
import z20.c;
import z20.d;

final class FlowableFlatMapStream$FlatMapStreamSubscriber<T, R> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -5127032662980523968L;
    public volatile boolean cancelled;
    public int consumed;
    public AutoCloseable currentCloseable;
    public Iterator<? extends R> currentIterator;
    public final c<? super R> downstream;
    public long emitted;
    public final AtomicThrowable error = new AtomicThrowable();
    public final h<? super T, ? extends Stream<? extends R>> mapper;
    public final int prefetch;
    public f<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public int sourceMode;
    public d upstream;
    public volatile boolean upstreamDone;

    public FlowableFlatMapStream$FlatMapStreamSubscriber(c<? super R> cVar, h<? super T, ? extends Stream<? extends R>> hVar, int i11) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.prefetch = i11;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        drain();
    }

    public void clearCurrentRethrowCloseError() throws Throwable {
        this.currentIterator = null;
        AutoCloseable autoCloseable = this.currentCloseable;
        this.currentCloseable = null;
        if (autoCloseable != null) {
            autoCloseable.close();
        }
    }

    public void clearCurrentSuppressCloseError() {
        try {
            clearCurrentRethrowCloseError();
        } catch (Throwable th2) {
            a.b(th2);
            o00.a.n(th2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb A[SYNTHETIC] */
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
            k00.f<T> r3 = r1.queue
            io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r1.error
            java.util.Iterator<? extends R> r0 = r1.currentIterator
            java.util.concurrent.atomic.AtomicLong r5 = r1.requested
            long r5 = r5.get()
            long r7 = r1.emitted
            int r9 = r1.prefetch
            int r10 = r9 >> 2
            int r9 = r9 - r10
            int r10 = r1.sourceMode
            r11 = 0
            r12 = 1
            if (r10 == r12) goto L_0x0026
            r10 = r12
            goto L_0x0027
        L_0x0026:
            r10 = r11
        L_0x0027:
            r13 = r7
            r8 = r12
            r6 = r5
            r5 = r0
        L_0x002b:
            boolean r0 = r1.cancelled
            if (r0 == 0) goto L_0x0037
            r3.clear()
            r17.clearCurrentSuppressCloseError()
            goto L_0x00e2
        L_0x0037:
            boolean r0 = r1.upstreamDone
            java.lang.Object r15 = r4.get()
            if (r15 == 0) goto L_0x004c
            java.lang.Object r0 = r4.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.onError(r0)
            r1.cancelled = r12
            goto L_0x00de
        L_0x004c:
            if (r5 != 0) goto L_0x00a5
            java.lang.Object r15 = r3.poll()     // Catch:{ all -> 0x009c }
            if (r15 != 0) goto L_0x0057
            r16 = r12
            goto L_0x0059
        L_0x0057:
            r16 = r11
        L_0x0059:
            if (r0 == 0) goto L_0x0063
            if (r16 == 0) goto L_0x0063
            r2.onComplete()
            r1.cancelled = r12
            goto L_0x00a5
        L_0x0063:
            if (r16 != 0) goto L_0x00a5
            if (r10 == 0) goto L_0x0076
            int r0 = r1.consumed
            int r0 = r0 + r12
            r1.consumed = r0
            if (r0 != r9) goto L_0x0076
            r1.consumed = r11
            z20.d r0 = r1.upstream
            long r11 = (long) r9
            r0.request(r11)
        L_0x0076:
            j00.h<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r1.mapper     // Catch:{ all -> 0x0094 }
            java.lang.Object r0 = r0.apply(r15)     // Catch:{ all -> 0x0094 }
            java.lang.String r11 = "The mapper returned a null Stream"
            java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x0094 }
            java.util.stream.Stream r0 = (java.util.stream.Stream) r0     // Catch:{ all -> 0x0094 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0094 }
            boolean r11 = r5.hasNext()     // Catch:{ all -> 0x0094 }
            if (r11 == 0) goto L_0x0092
            r1.currentIterator = r5     // Catch:{ all -> 0x0094 }
            r1.currentCloseable = r0     // Catch:{ all -> 0x0094 }
            goto L_0x00de
        L_0x0092:
            r5 = 0
            goto L_0x00de
        L_0x0094:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r0)
            r1.trySignalError(r2, r0)
            goto L_0x00de
        L_0x009c:
            r0 = move-exception
            r11 = r0
            io.reactivex.rxjava3.exceptions.a.b(r11)
            r1.trySignalError(r2, r11)
            goto L_0x00de
        L_0x00a5:
            if (r5 == 0) goto L_0x00e2
            int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00e2
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00d7 }
            java.lang.String r11 = "The Stream.Iterator returned a null value"
            java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x00d7 }
            boolean r11 = r1.cancelled
            if (r11 != 0) goto L_0x00de
            r2.onNext(r0)
            r11 = 1
            long r13 = r13 + r11
            boolean r0 = r1.cancelled
            if (r0 != 0) goto L_0x00de
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x00de
            r17.clearCurrentRethrowCloseError()     // Catch:{ all -> 0x00cc }
            goto L_0x0092
        L_0x00cc:
            r0 = move-exception
            r5 = 0
            goto L_0x00d0
        L_0x00cf:
            r0 = move-exception
        L_0x00d0:
            io.reactivex.rxjava3.exceptions.a.b(r0)
            r1.trySignalError(r2, r0)
            goto L_0x00de
        L_0x00d7:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r0)
            r1.trySignalError(r2, r0)
        L_0x00de:
            r11 = 0
            r12 = 1
            goto L_0x002b
        L_0x00e2:
            r1.emitted = r13
            int r0 = -r8
            int r8 = r1.addAndGet(r0)
            if (r8 != 0) goto L_0x00ec
            return
        L_0x00ec:
            java.util.concurrent.atomic.AtomicLong r0 = r1.requested
            long r6 = r0.get()
            goto L_0x00de
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream$FlatMapStreamSubscriber.drain():void");
    }

    public void onComplete() {
        this.upstreamDone = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.error.compareAndSet((Object) null, th2)) {
            this.upstreamDone = true;
            drain();
            return;
        }
        o00.a.n(th2);
    }

    public void onNext(T t11) {
        if (this.sourceMode == 2 || this.queue.offer(t11)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue full?!"));
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.upstreamDone = true;
                    this.downstream.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.downstream.onSubscribe(this);
                    dVar.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            dVar.request((long) this.prefetch);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }

    public void trySignalError(c<?> cVar, Throwable th2) {
        if (this.error.compareAndSet((Object) null, th2)) {
            this.upstream.cancel();
            this.cancelled = true;
            cVar.onError(th2);
            return;
        }
        o00.a.n(th2);
    }
}
