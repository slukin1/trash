package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;

final class FlowableCombineLatest$CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
    private static final long serialVersionUID = -5082275438355852221L;
    public volatile boolean cancelled;
    public final h<? super Object[], ? extends R> combiner;
    public int completedSources;
    public final boolean delayErrors;
    public volatile boolean done;
    public final c<? super R> downstream;
    public final AtomicThrowable error;
    public final Object[] latest;
    public int nonEmptySources;
    public boolean outputFused;
    public final a<Object> queue;
    public final AtomicLong requested;
    public final FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] subscribers;

    public FlowableCombineLatest$CombineLatestCoordinator(c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i11, int i12, boolean z11) {
        this.downstream = cVar;
        this.combiner = hVar;
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = new FlowableCombineLatest$CombineLatestInnerSubscriber[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            flowableCombineLatest$CombineLatestInnerSubscriberArr[i13] = new FlowableCombineLatest$CombineLatestInnerSubscriber<>(this, i13, i12);
        }
        this.subscribers = flowableCombineLatest$CombineLatestInnerSubscriberArr;
        this.latest = new Object[i11];
        this.queue = new a<>(i12);
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
        this.delayErrors = z11;
    }

    public void cancel() {
        this.cancelled = true;
        cancelAll();
        drain();
    }

    public void cancelAll() {
        for (FlowableCombineLatest$CombineLatestInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, c<?> cVar, a<?> aVar) {
        if (this.cancelled) {
            cancelAll();
            aVar.clear();
            this.error.tryTerminateAndReport();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!this.delayErrors) {
                Throwable e11 = ExceptionHelper.e(this.error);
                if (e11 != null && e11 != ExceptionHelper.f55703a) {
                    cancelAll();
                    aVar.clear();
                    cVar.onError(e11);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    cancelAll();
                    cVar.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                cancelAll();
                this.error.tryTerminateConsumer(cVar);
                return true;
            }
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }
    }

    public void drainAsync() {
        int i11;
        c<? super R> cVar = this.downstream;
        a<Object> aVar = this.queue;
        int i12 = 1;
        do {
            long j11 = this.requested.get();
            long j12 = 0;
            while (true) {
                i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                if (i11 == 0) {
                    break;
                }
                boolean z11 = this.done;
                Object poll = aVar.poll();
                boolean z12 = poll == null;
                if (!checkTerminated(z11, z12, cVar, aVar)) {
                    if (z12) {
                        break;
                    }
                    try {
                        Object apply = this.combiner.apply((Object[]) aVar.poll());
                        Objects.requireNonNull(apply, "The combiner returned a null value");
                        cVar.onNext(apply);
                        ((FlowableCombineLatest$CombineLatestInnerSubscriber) poll).requestOne();
                        j12++;
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        cancelAll();
                        ExceptionHelper.a(this.error, th2);
                        cVar.onError(ExceptionHelper.e(this.error));
                        return;
                    }
                } else {
                    return;
                }
            }
            if (i11 != 0 || !checkTerminated(this.done, aVar.isEmpty(), cVar, aVar)) {
                if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                    this.requested.addAndGet(-j12);
                }
                i12 = addAndGet(-i12);
            } else {
                return;
            }
        } while (i12 != 0);
    }

    public void drainOutput() {
        c<? super R> cVar = this.downstream;
        a<Object> aVar = this.queue;
        int i11 = 1;
        while (!this.cancelled) {
            Throwable th2 = (Throwable) this.error.get();
            if (th2 != null) {
                aVar.clear();
                cVar.onError(th2);
                return;
            }
            boolean z11 = this.done;
            boolean isEmpty = aVar.isEmpty();
            if (!isEmpty) {
                cVar.onNext(null);
            }
            if (!z11 || !isEmpty) {
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                cVar.onComplete();
                return;
            }
        }
        aVar.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void innerComplete(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Object[] r0 = r2.latest     // Catch:{ all -> 0x001c }
            r3 = r0[r3]     // Catch:{ all -> 0x001c }
            r1 = 1
            if (r3 == 0) goto L_0x0015
            int r3 = r2.completedSources     // Catch:{ all -> 0x001c }
            int r3 = r3 + r1
            int r0 = r0.length     // Catch:{ all -> 0x001c }
            if (r3 != r0) goto L_0x0011
            r2.done = r1     // Catch:{ all -> 0x001c }
            goto L_0x0017
        L_0x0011:
            r2.completedSources = r3     // Catch:{ all -> 0x001c }
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            return
        L_0x0015:
            r2.done = r1     // Catch:{ all -> 0x001c }
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            r2.drain()
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest$CombineLatestCoordinator.innerComplete(int):void");
    }

    public void innerError(int i11, Throwable th2) {
        if (!ExceptionHelper.a(this.error, th2)) {
            o00.a.n(th2);
        } else if (!this.delayErrors) {
            cancelAll();
            this.done = true;
            drain();
        } else {
            innerComplete(i11);
        }
    }

    public void innerValue(int i11, T t11) {
        boolean z11;
        synchronized (this) {
            Object[] objArr = this.latest;
            int i12 = this.nonEmptySources;
            if (objArr[i11] == null) {
                i12++;
                this.nonEmptySources = i12;
            }
            objArr[i11] = t11;
            if (objArr.length == i12) {
                this.queue.l(this.subscribers[i11], objArr.clone());
                z11 = false;
            } else {
                z11 = true;
            }
        }
        if (z11) {
            this.subscribers[i11].requestOne();
        } else {
            drain();
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public R poll() throws Throwable {
        Object poll = this.queue.poll();
        if (poll == null) {
            return null;
        }
        R apply = this.combiner.apply((Object[]) this.queue.poll());
        Objects.requireNonNull(apply, "The combiner returned a null value");
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) poll).requestOne();
        return apply;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }

    public int requestFusion(int i11) {
        boolean z11 = false;
        if ((i11 & 4) != 0) {
            return 0;
        }
        int i12 = i11 & 2;
        if (i12 != 0) {
            z11 = true;
        }
        this.outputFused = z11;
        return i12;
    }

    public void subscribe(z20.b<? extends T>[] bVarArr, int i11) {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = this.subscribers;
        for (int i12 = 0; i12 < i11 && !this.done && !this.cancelled; i12++) {
            bVarArr[i12].subscribe(flowableCombineLatest$CombineLatestInnerSubscriberArr[i12]);
        }
    }
}
