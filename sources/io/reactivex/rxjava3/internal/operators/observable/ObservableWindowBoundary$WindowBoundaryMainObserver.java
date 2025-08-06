package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements k<T>, b, Runnable {
    public static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    public final n<T, B> boundaryObserver = new n<>(this);
    public final int capacityHint;
    public volatile boolean done;
    public final k<? super Observable<T>> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
    public final AtomicBoolean stopWindows = new AtomicBoolean();
    public final AtomicReference<b> upstream = new AtomicReference<>();
    public UnicastSubject<T> window;
    public final AtomicInteger windows = new AtomicInteger(1);

    public ObservableWindowBoundary$WindowBoundaryMainObserver(k<? super Observable<T>> kVar, int i11) {
        this.downstream = kVar;
        this.capacityHint = i11;
    }

    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true)) {
            this.boundaryObserver.dispose();
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super Observable<T>> kVar = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int i11 = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z11 = this.done;
                if (!z11 || atomicThrowable.get() == null) {
                    Object poll = mpscLinkedQueue.poll();
                    boolean z12 = poll == null;
                    if (z11 && z12) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate == null) {
                            if (unicastSubject != null) {
                                this.window = null;
                                unicastSubject.onComplete();
                            }
                            kVar.onComplete();
                            return;
                        }
                        if (unicastSubject != null) {
                            this.window = null;
                            unicastSubject.onError(terminate);
                        }
                        kVar.onError(terminate);
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else if (poll != NEXT_WINDOW) {
                        unicastSubject.onNext(poll);
                    } else {
                        if (unicastSubject != null) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        if (!this.stopWindows.get()) {
                            UnicastSubject<T> d11 = UnicastSubject.d(this.capacityHint, this);
                            this.window = d11;
                            this.windows.getAndIncrement();
                            o oVar = new o(d11);
                            kVar.onNext(oVar);
                            if (oVar.c()) {
                                d11.onComplete();
                            }
                        }
                    }
                } else {
                    mpscLinkedQueue.clear();
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onError(terminate2);
                    }
                    kVar.onError(terminate2);
                    return;
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
    }

    public void innerError(Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.boundaryObserver.dispose();
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            innerNext();
        }
    }

    public void run() {
        if (this.windows.decrementAndGet() == 0) {
            DisposableHelper.dispose(this.upstream);
        }
    }
}
