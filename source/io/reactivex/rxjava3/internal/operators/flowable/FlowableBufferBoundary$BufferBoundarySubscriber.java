package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import j00.k;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.b;
import z20.c;
import z20.d;

final class FlowableBufferBoundary$BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -8466418554264089604L;
    public final h<? super Open, ? extends b<? extends Close>> bufferClose;
    public final b<? extends Open> bufferOpen;
    public final k<C> bufferSupplier;
    public Map<Long, C> buffers = new LinkedHashMap();
    public volatile boolean cancelled;
    public volatile boolean done;
    public final c<? super C> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public long index;
    public final a<C> queue = new a<>(Flowable.b());
    public final AtomicLong requested = new AtomicLong();
    public final CompositeDisposable subscribers = new CompositeDisposable();
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public static final class BufferOpenSubscriber<Open> extends AtomicReference<d> implements e<Open>, io.reactivex.rxjava3.disposables.b {
        private static final long serialVersionUID = -8498650778633225126L;
        public final FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> parent;

        public BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> flowableBufferBoundary$BufferBoundarySubscriber) {
            this.parent = flowableBufferBoundary$BufferBoundarySubscriber;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.openComplete(this);
        }

        public void onError(Throwable th2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, th2);
        }

        public void onNext(Open open) {
            this.parent.open(open);
        }

        public void onSubscribe(d dVar) {
            SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary$BufferBoundarySubscriber(c<? super C> cVar, b<? extends Open> bVar, h<? super Open, ? extends b<? extends Close>> hVar, k<C> kVar) {
        this.downstream = cVar;
        this.bufferSupplier = kVar;
        this.bufferOpen = bVar;
        this.bufferClose = hVar;
    }

    public void boundaryError(io.reactivex.rxjava3.disposables.b bVar, Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.b(bVar);
        onError(th2);
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this.upstream)) {
            this.cancelled = true;
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            if (getAndIncrement() != 0) {
                this.queue.clear();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r4 == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r3.done = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber<T, C> r4, long r5) {
        /*
            r3 = this;
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.subscribers
            r0.b(r4)
            io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.subscribers
            int r4 = r4.e()
            r0 = 1
            if (r4 != 0) goto L_0x0015
            java.util.concurrent.atomic.AtomicReference<z20.d> r4 = r3.upstream
            io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.cancel(r4)
            r4 = r0
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            monitor-enter(r3)
            java.util.Map<java.lang.Long, C> r1 = r3.buffers     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x001d
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x001d:
            io.reactivex.rxjava3.internal.queue.a<C> r2 = r3.queue     // Catch:{ all -> 0x0033 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0033 }
            java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0033 }
            r2.offer(r5)     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002f
            r3.done = r0
        L_0x002f:
            r3.drain()
            return
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber.close(io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
    }

    public void drain() {
        int i11;
        if (getAndIncrement() == 0) {
            long j11 = this.emitted;
            c<? super C> cVar = this.downstream;
            a<C> aVar = this.queue;
            int i12 = 1;
            do {
                long j12 = this.requested.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.cancelled) {
                        aVar.clear();
                        return;
                    } else {
                        boolean z11 = this.done;
                        if (!z11 || this.errors.get() == null) {
                            Collection collection = (Collection) aVar.poll();
                            boolean z12 = collection == null;
                            if (z11 && z12) {
                                cVar.onComplete();
                                return;
                            } else if (z12) {
                                break;
                            } else {
                                cVar.onNext(collection);
                                j11++;
                            }
                        } else {
                            aVar.clear();
                            this.errors.tryTerminateConsumer((c<?>) cVar);
                            return;
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.cancelled) {
                        aVar.clear();
                        return;
                    } else if (this.done) {
                        if (this.errors.get() != null) {
                            aVar.clear();
                            this.errors.tryTerminateConsumer((c<?>) cVar);
                            return;
                        } else if (aVar.isEmpty()) {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j11;
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }
    }

    public void onComplete() {
        this.subscribers.dispose();
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map != null) {
                for (C offer : map.values()) {
                    this.queue.offer(offer);
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map != null) {
                for (C add : map.values()) {
                    add.add(t11);
                }
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
            this.subscribers.a(bufferOpenSubscriber);
            this.bufferOpen.subscribe(bufferOpenSubscriber);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void open(Open open) {
        try {
            C c11 = this.bufferSupplier.get();
            Objects.requireNonNull(c11, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) c11;
            Object apply = this.bufferClose.apply(open);
            Objects.requireNonNull(apply, "The bufferClose returned a null Publisher");
            b bVar = (b) apply;
            long j11 = this.index;
            this.index = 1 + j11;
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    map.put(Long.valueOf(j11), collection);
                    FlowableBufferBoundary$BufferCloseSubscriber flowableBufferBoundary$BufferCloseSubscriber = new FlowableBufferBoundary$BufferCloseSubscriber(this, j11);
                    this.subscribers.a(flowableBufferBoundary$BufferCloseSubscriber);
                    bVar.subscribe(flowableBufferBoundary$BufferCloseSubscriber);
                }
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            SubscriptionHelper.cancel(this.upstream);
            onError(th2);
        }
    }

    public void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
        this.subscribers.b(bufferOpenSubscriber);
        if (this.subscribers.e() == 0) {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
        }
    }

    public void request(long j11) {
        io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        drain();
    }
}
