package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j00.h;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableBufferBoundary$BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = -8466418554264089604L;
    public final h<? super Open, ? extends j<? extends Close>> bufferClose;
    public final j<? extends Open> bufferOpen;
    public final j00.k<C> bufferSupplier;
    public Map<Long, C> buffers = new LinkedHashMap();
    public volatile boolean cancelled;
    public volatile boolean done;
    public final k<? super C> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public long index;
    public final CompositeDisposable observers = new CompositeDisposable();
    public final a<C> queue = new a<>(Observable.a());
    public final AtomicReference<b> upstream = new AtomicReference<>();

    public static final class BufferOpenObserver<Open> extends AtomicReference<b> implements k<Open>, b {
        private static final long serialVersionUID = -8498650778633225126L;
        public final ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> parent;

        public BufferOpenObserver(ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> observableBufferBoundary$BufferBoundaryObserver) {
            this.parent = observableBufferBoundary$BufferBoundaryObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.openComplete(this);
        }

        public void onError(Throwable th2) {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, th2);
        }

        public void onNext(Open open) {
            this.parent.open(open);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableBufferBoundary$BufferBoundaryObserver(k<? super C> kVar, j<? extends Open> jVar, h<? super Open, ? extends j<? extends Close>> hVar, j00.k<C> kVar2) {
        this.downstream = kVar;
        this.bufferSupplier = kVar2;
        this.bufferOpen = jVar;
        this.bufferClose = hVar;
    }

    public void boundaryError(b bVar, Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        this.observers.b(bVar);
        onError(th2);
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
    public void close(io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver<T, C> r4, long r5) {
        /*
            r3 = this;
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.observers
            r0.b(r4)
            io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.observers
            int r4 = r4.e()
            r0 = 1
            if (r4 != 0) goto L_0x0015
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.disposables.b> r4 = r3.upstream
            io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r4)
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver.close(io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
    }

    public void dispose() {
        if (DisposableHelper.dispose(this.upstream)) {
            this.cancelled = true;
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            if (getAndIncrement() != 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super C> kVar = this.downstream;
            a<C> aVar = this.queue;
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = this.done;
                if (!z11 || this.errors.get() == null) {
                    Collection collection = (Collection) aVar.poll();
                    boolean z12 = collection == null;
                    if (z11 && z12) {
                        kVar.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        kVar.onNext(collection);
                    }
                } else {
                    aVar.clear();
                    this.errors.tryTerminateConsumer((k<?>) kVar);
                    return;
                }
            }
            aVar.clear();
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        this.observers.dispose();
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
            this.observers.dispose();
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

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
            this.observers.a(bufferOpenObserver);
            this.bufferOpen.subscribe(bufferOpenObserver);
        }
    }

    public void open(Open open) {
        try {
            C c11 = this.bufferSupplier.get();
            Objects.requireNonNull(c11, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) c11;
            Object apply = this.bufferClose.apply(open);
            Objects.requireNonNull(apply, "The bufferClose returned a null ObservableSource");
            j jVar = (j) apply;
            long j11 = this.index;
            this.index = 1 + j11;
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    map.put(Long.valueOf(j11), collection);
                    ObservableBufferBoundary$BufferCloseObserver observableBufferBoundary$BufferCloseObserver = new ObservableBufferBoundary$BufferCloseObserver(this, j11);
                    this.observers.a(observableBufferBoundary$BufferCloseObserver);
                    jVar.subscribe(observableBufferBoundary$BufferCloseObserver);
                }
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            DisposableHelper.dispose(this.upstream);
            onError(th2);
        }
    }

    public void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
        this.observers.b(bufferOpenObserver);
        if (this.observers.e() == 0) {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }
    }
}
