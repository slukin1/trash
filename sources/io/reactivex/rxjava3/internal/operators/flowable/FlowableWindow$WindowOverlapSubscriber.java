package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements e<T>, d, Runnable {
    private static final long serialVersionUID = 2428527070996323976L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final c<? super Flowable<T>> downstream;
    public Throwable error;
    public final AtomicBoolean firstRequest = new AtomicBoolean();
    public long index;
    public final AtomicBoolean once = new AtomicBoolean();
    public long produced;
    public final a<UnicastProcessor<T>> queue;
    public final AtomicLong requested = new AtomicLong();
    public final long size;
    public final long skip;
    public d upstream;
    public final ArrayDeque<UnicastProcessor<T>> windows = new ArrayDeque<>();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableWindow$WindowOverlapSubscriber(c<? super Flowable<T>> cVar, long j11, long j12, int i11) {
        super(1);
        this.downstream = cVar;
        this.size = j11;
        this.skip = j12;
        this.queue = new a<>(i11);
        this.bufferSize = i11;
    }

    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true)) {
            run();
        }
        drain();
    }

    public boolean checkTerminated(boolean z11, boolean z12, c<?> cVar, a<?> aVar) {
        if (!z11) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            aVar.clear();
            cVar.onError(th2);
            return true;
        } else if (!z12) {
            return false;
        } else {
            cVar.onComplete();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        if (r10 != 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        if (r15.cancelled == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006e, code lost:
        if (checkTerminated(r15.done, r1.isEmpty(), r0, r1) == false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r8 == 0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (r4 == Long.MAX_VALUE) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007e, code lost:
        r15.requested.addAndGet(-r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x000f, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r15.wip
            int r0 = r0.getAndIncrement()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            z20.c<? super io.reactivex.rxjava3.core.Flowable<T>> r0 = r15.downstream
            io.reactivex.rxjava3.internal.queue.a<io.reactivex.rxjava3.processors.UnicastProcessor<T>> r1 = r15.queue
            r2 = 1
            r3 = r2
        L_0x000f:
            boolean r4 = r15.cancelled
            if (r4 == 0) goto L_0x001f
        L_0x0013:
            java.lang.Object r4 = r1.poll()
            io.reactivex.rxjava3.processors.UnicastProcessor r4 = (io.reactivex.rxjava3.processors.UnicastProcessor) r4
            if (r4 == 0) goto L_0x0084
            r4.onComplete()
            goto L_0x0013
        L_0x001f:
            java.util.concurrent.atomic.AtomicLong r4 = r15.requested
            long r4 = r4.get()
            r6 = 0
            r8 = r6
        L_0x0028:
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x005d
            boolean r11 = r15.done
            java.lang.Object r12 = r1.poll()
            io.reactivex.rxjava3.processors.UnicastProcessor r12 = (io.reactivex.rxjava3.processors.UnicastProcessor) r12
            if (r12 != 0) goto L_0x0038
            r13 = r2
            goto L_0x0039
        L_0x0038:
            r13 = 0
        L_0x0039:
            boolean r14 = r15.cancelled
            if (r14 == 0) goto L_0x003e
            goto L_0x000f
        L_0x003e:
            boolean r11 = r15.checkTerminated(r11, r13, r0, r1)
            if (r11 == 0) goto L_0x0045
            return
        L_0x0045:
            if (r13 == 0) goto L_0x0048
            goto L_0x005d
        L_0x0048:
            io.reactivex.rxjava3.internal.operators.flowable.s r10 = new io.reactivex.rxjava3.internal.operators.flowable.s
            r10.<init>(r12)
            r0.onNext(r10)
            boolean r10 = r10.m()
            if (r10 == 0) goto L_0x0059
            r12.onComplete()
        L_0x0059:
            r10 = 1
            long r8 = r8 + r10
            goto L_0x0028
        L_0x005d:
            if (r10 != 0) goto L_0x0071
            boolean r10 = r15.cancelled
            if (r10 == 0) goto L_0x0064
            goto L_0x000f
        L_0x0064:
            boolean r10 = r15.done
            boolean r11 = r1.isEmpty()
            boolean r10 = r15.checkTerminated(r10, r11, r0, r1)
            if (r10 == 0) goto L_0x0071
            return
        L_0x0071:
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0084
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0084
            java.util.concurrent.atomic.AtomicLong r4 = r15.requested
            long r5 = -r8
            r4.addAndGet(r5)
        L_0x0084:
            java.util.concurrent.atomic.AtomicInteger r4 = r15.wip
            int r3 = -r3
            int r3 = r4.addAndGet(r3)
            if (r3 != 0) goto L_0x000f
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber.drain():void");
    }

    public void onComplete() {
        Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
        while (it2.hasNext()) {
            it2.next().onComplete();
        }
        this.windows.clear();
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
        while (it2.hasNext()) {
            it2.next().onError(th2);
        }
        this.windows.clear();
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        UnicastProcessor unicastProcessor;
        long j11 = this.index;
        if (j11 != 0 || this.cancelled) {
            unicastProcessor = null;
        } else {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.o(this.bufferSize, this);
            this.windows.offer(unicastProcessor);
        }
        long j12 = j11 + 1;
        Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
        while (it2.hasNext()) {
            it2.next().onNext(t11);
        }
        if (unicastProcessor != null) {
            this.queue.offer(unicastProcessor);
            drain();
        }
        long j13 = this.produced + 1;
        if (j13 == this.size) {
            this.produced = j13 - this.skip;
            z20.a poll = this.windows.poll();
            if (poll != null) {
                poll.onComplete();
            }
        } else {
            this.produced = j13;
        }
        if (j12 == this.skip) {
            this.index = 0;
        } else {
            this.index = j12;
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
            b.a(this.requested, j11);
            if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                this.upstream.request(b.d(this.skip, j11));
            } else {
                this.upstream.request(b.c(this.size, b.d(this.skip, j11 - 1)));
            }
            drain();
        }
    }

    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
