package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

abstract class FlowableReplay$BoundedReplayBuffer<T> extends AtomicReference<FlowableReplay$Node> implements k<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    public final boolean eagerTruncate;
    public long index;
    public int size;
    public FlowableReplay$Node tail;

    public FlowableReplay$BoundedReplayBuffer(boolean z11) {
        this.eagerTruncate = z11;
        FlowableReplay$Node flowableReplay$Node = new FlowableReplay$Node((Object) null, 0);
        this.tail = flowableReplay$Node;
        set(flowableReplay$Node);
    }

    public final void addLast(FlowableReplay$Node flowableReplay$Node) {
        this.tail.set(flowableReplay$Node);
        this.tail = flowableReplay$Node;
        this.size++;
    }

    public final void collect(Collection<? super T> collection) {
        FlowableReplay$Node head = getHead();
        while (true) {
            head = (FlowableReplay$Node) head.get();
            if (head != null) {
                Object leaveTransform = leaveTransform(head.value);
                if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                    collection.add(NotificationLite.getValue(leaveTransform));
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void complete() {
        Object enterTransform = enterTransform(NotificationLite.complete(), true);
        long j11 = this.index + 1;
        this.index = j11;
        addLast(new FlowableReplay$Node(enterTransform, j11));
        truncateFinal();
    }

    public Object enterTransform(Object obj, boolean z11) {
        return obj;
    }

    public final void error(Throwable th2) {
        Object enterTransform = enterTransform(NotificationLite.error(th2), true);
        long j11 = this.index + 1;
        this.index = j11;
        addLast(new FlowableReplay$Node(enterTransform, j11));
        truncateFinal();
    }

    public FlowableReplay$Node getHead() {
        return (FlowableReplay$Node) get();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isComplete(leaveTransform(obj));
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isError(leaveTransform(obj));
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    public final void next(T t11) {
        Object enterTransform = enterTransform(NotificationLite.next(t11), false);
        long j11 = this.index + 1;
        this.index = j11;
        addLast(new FlowableReplay$Node(enterTransform, j11));
        truncate();
    }

    public final void removeFirst() {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node) ((FlowableReplay$Node) get()).get();
        if (flowableReplay$Node != null) {
            this.size--;
            setFirst(flowableReplay$Node);
            return;
        }
        throw new IllegalStateException("Empty list!");
    }

    public final void removeSome(int i11) {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node) get();
        while (i11 > 0) {
            flowableReplay$Node = (FlowableReplay$Node) flowableReplay$Node.get();
            i11--;
            this.size--;
        }
        setFirst(flowableReplay$Node);
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node) get();
        if (flowableReplay$Node2.get() == null) {
            this.tail = flowableReplay$Node2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r2 != Long.MAX_VALUE) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node) r14.index();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r5 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        r5 = getHead();
        r14.index = r5;
        io.reactivex.rxjava3.internal.util.b.a(r14.totalRequested, r5.index);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r10 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r10 == 0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r14.isDisposed() == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        r14.index = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node) r5.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r12 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r5 = leaveTransform(r12.value);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (io.reactivex.rxjava3.internal.util.NotificationLite.accept(r5, r14.child) == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r14.index = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        r8 = r8 + 1;
        r2 = r2 - 1;
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        io.reactivex.rxjava3.exceptions.a.b(r0);
        r14.index = null;
        r14.dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0070, code lost:
        if (io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5) != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0078, code lost:
        r14.child.onError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        o00.a.n(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
        if (r10 != 0) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0088, code lost:
        if (r14.isDisposed() == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008a, code lost:
        r14.index = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008f, code lost:
        if (r8 == 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0091, code lost:
        r14.index = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
        if (r0 != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        r14.produced(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0098, code lost:
        monitor-enter(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009b, code lost:
        if (r14.missed != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        r14.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a1, code lost:
        r14.missed = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a3, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r2 = r14.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription<T> r14) {
        /*
            r13 = this;
            monitor-enter(r14)
            boolean r0 = r14.emitting     // Catch:{ all -> 0x00a9 }
            r1 = 1
            if (r0 == 0) goto L_0x000a
            r14.missed = r1     // Catch:{ all -> 0x00a9 }
            monitor-exit(r14)     // Catch:{ all -> 0x00a9 }
            return
        L_0x000a:
            r14.emitting = r1     // Catch:{ all -> 0x00a9 }
            monitor-exit(r14)     // Catch:{ all -> 0x00a9 }
        L_0x000d:
            long r2 = r14.get()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r4 = 0
            if (r0 != 0) goto L_0x001d
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r0 = r4
        L_0x001e:
            java.lang.Object r5 = r14.index()
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node) r5
            r6 = 0
            if (r5 != 0) goto L_0x0035
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = r13.getHead()
            r14.index = r5
            java.util.concurrent.atomic.AtomicLong r8 = r14.totalRequested
            long r9 = r5.index
            io.reactivex.rxjava3.internal.util.b.a(r8, r9)
        L_0x0035:
            r8 = r6
        L_0x0036:
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            r11 = 0
            if (r10 == 0) goto L_0x0082
            boolean r12 = r14.isDisposed()
            if (r12 == 0) goto L_0x0044
            r14.index = r11
            return
        L_0x0044:
            java.lang.Object r12 = r5.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node) r12
            if (r12 == 0) goto L_0x0082
            java.lang.Object r5 = r12.value
            java.lang.Object r5 = r13.leaveTransform(r5)
            z20.c<? super T> r10 = r14.child     // Catch:{ all -> 0x0063 }
            boolean r10 = io.reactivex.rxjava3.internal.util.NotificationLite.accept((java.lang.Object) r5, r10)     // Catch:{ all -> 0x0063 }
            if (r10 == 0) goto L_0x005d
            r14.index = r11     // Catch:{ all -> 0x0063 }
            return
        L_0x005d:
            r10 = 1
            long r8 = r8 + r10
            long r2 = r2 - r10
            r5 = r12
            goto L_0x0036
        L_0x0063:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r0)
            r14.index = r11
            r14.dispose()
            boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5)
            if (r1 != 0) goto L_0x007e
            boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.isComplete(r5)
            if (r1 != 0) goto L_0x007e
            z20.c<? super T> r14 = r14.child
            r14.onError(r0)
            goto L_0x0081
        L_0x007e:
            o00.a.n(r0)
        L_0x0081:
            return
        L_0x0082:
            if (r10 != 0) goto L_0x008d
            boolean r2 = r14.isDisposed()
            if (r2 == 0) goto L_0x008d
            r14.index = r11
            return
        L_0x008d:
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0098
            r14.index = r5
            if (r0 != 0) goto L_0x0098
            r14.produced(r8)
        L_0x0098:
            monitor-enter(r14)
            boolean r0 = r14.missed     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x00a1
            r14.emitting = r4     // Catch:{ all -> 0x00a6 }
            monitor-exit(r14)     // Catch:{ all -> 0x00a6 }
            return
        L_0x00a1:
            r14.missed = r4     // Catch:{ all -> 0x00a6 }
            monitor-exit(r14)     // Catch:{ all -> 0x00a6 }
            goto L_0x000d
        L_0x00a6:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00a6 }
            throw r0
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00a9 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer.replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
    }

    public final void setFirst(FlowableReplay$Node flowableReplay$Node) {
        if (this.eagerTruncate) {
            FlowableReplay$Node flowableReplay$Node2 = new FlowableReplay$Node((Object) null, flowableReplay$Node.index);
            flowableReplay$Node2.lazySet(flowableReplay$Node.get());
            flowableReplay$Node = flowableReplay$Node2;
        }
        set(flowableReplay$Node);
    }

    public final void trimHead() {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node) get();
        if (flowableReplay$Node.value != null) {
            FlowableReplay$Node flowableReplay$Node2 = new FlowableReplay$Node((Object) null, 0);
            flowableReplay$Node2.lazySet(flowableReplay$Node.get());
            set(flowableReplay$Node2);
        }
    }

    public abstract void truncate();

    public void truncateFinal() {
        trimHead();
    }
}
