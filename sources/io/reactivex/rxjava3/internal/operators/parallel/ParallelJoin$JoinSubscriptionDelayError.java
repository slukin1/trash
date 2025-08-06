package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import z20.c;

final class ParallelJoin$JoinSubscriptionDelayError<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = -5737965195918321883L;

    public ParallelJoin$JoinSubscriptionDelayError(c<? super T> cVar, int i11, int i12) {
        super(cVar, i11, i12);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r12 == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r15 == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r0.errors.tryTerminateConsumer((z20.c<?>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r15 == false) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drainLoop() {
        /*
            r18 = this;
            r0 = r18
            io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.subscribers
            int r2 = r1.length
            z20.c<? super T> r3 = r0.downstream
            r5 = 1
        L_0x0008:
            java.util.concurrent.atomic.AtomicLong r6 = r0.requested
            long r6 = r6.get()
            r8 = 0
            r10 = r8
        L_0x0011:
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0057
            boolean r12 = r0.cancelled
            if (r12 == 0) goto L_0x001d
            r18.cleanup()
            return
        L_0x001d:
            java.util.concurrent.atomic.AtomicInteger r12 = r0.done
            int r12 = r12.get()
            if (r12 != 0) goto L_0x0027
            r12 = 1
            goto L_0x0028
        L_0x0027:
            r12 = 0
        L_0x0028:
            r14 = 0
            r15 = 1
        L_0x002a:
            if (r14 >= r2) goto L_0x004b
            r4 = r1[r14]
            k00.e<T> r13 = r4.queue
            if (r13 == 0) goto L_0x0048
            java.lang.Object r13 = r13.poll()
            if (r13 == 0) goto L_0x0048
            r3.onNext(r13)
            r4.requestOne()
            r16 = 1
            long r10 = r10 + r16
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0047
            goto L_0x0057
        L_0x0047:
            r15 = 0
        L_0x0048:
            int r14 = r14 + 1
            goto L_0x002a
        L_0x004b:
            if (r12 == 0) goto L_0x0055
            if (r15 == 0) goto L_0x0055
            io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.errors
            r1.tryTerminateConsumer((z20.c<?>) r3)
            return
        L_0x0055:
            if (r15 == 0) goto L_0x0011
        L_0x0057:
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x008d
            boolean r4 = r0.cancelled
            if (r4 == 0) goto L_0x0063
            r18.cleanup()
            return
        L_0x0063:
            java.util.concurrent.atomic.AtomicInteger r4 = r0.done
            int r4 = r4.get()
            if (r4 != 0) goto L_0x006d
            r4 = 1
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            r6 = 0
        L_0x006f:
            if (r6 >= r2) goto L_0x0082
            r7 = r1[r6]
            k00.e<T> r7 = r7.queue
            if (r7 == 0) goto L_0x007f
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x007f
            r13 = 0
            goto L_0x0083
        L_0x007f:
            int r6 = r6 + 1
            goto L_0x006f
        L_0x0082:
            r13 = 1
        L_0x0083:
            if (r4 == 0) goto L_0x008d
            if (r13 == 0) goto L_0x008d
            io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.errors
            r1.tryTerminateConsumer((z20.c<?>) r3)
            return
        L_0x008d:
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0096
            java.util.concurrent.atomic.AtomicLong r4 = r0.requested
            io.reactivex.rxjava3.internal.util.b.e(r4, r10)
        L_0x0096:
            int r4 = -r5
            int r5 = r0.addAndGet(r4)
            if (r5 != 0) goto L_0x0008
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$JoinSubscriptionDelayError.drainLoop():void");
    }

    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done.decrementAndGet();
            drain();
        }
    }

    public void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t11) {
        if (get() != 0 || !compareAndSet(0, 1)) {
            if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t11)) {
                parallelJoin$JoinInnerSubscriber.cancel();
                this.errors.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
            }
            if (getAndIncrement() != 0) {
                return;
            }
        } else {
            if (this.requested.get() != 0) {
                this.downstream.onNext(t11);
                if (this.requested.get() != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                parallelJoin$JoinInnerSubscriber.request(1);
            } else if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t11)) {
                parallelJoin$JoinInnerSubscriber.cancel();
                this.errors.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
                drainLoop();
                return;
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        drainLoop();
    }
}
