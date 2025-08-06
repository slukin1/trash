package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.b;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements e<T>, d, Runnable {
    public static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    public final r<T, B> boundarySubscriber = new r<>(this);
    public final int capacityHint;
    public volatile boolean done;
    public final c<? super Flowable<T>> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicBoolean stopWindows = new AtomicBoolean();
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public UnicastProcessor<T> window;
    public final AtomicInteger windows = new AtomicInteger(1);

    public FlowableWindowBoundary$WindowBoundaryMainSubscriber(c<? super Flowable<T>> cVar, int i11) {
        this.downstream = cVar;
        this.capacityHint = i11;
    }

    public void cancel() {
        if (this.stopWindows.compareAndSet(false, true)) {
            this.boundarySubscriber.dispose();
            if (this.windows.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.upstream);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super Flowable<T>> cVar = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            long j11 = this.emitted;
            int i11 = 1;
            while (this.windows.get() != 0) {
                UnicastProcessor<T> unicastProcessor = this.window;
                boolean z11 = this.done;
                if (!z11 || atomicThrowable.get() == null) {
                    Object poll = mpscLinkedQueue.poll();
                    boolean z12 = poll == null;
                    if (z11 && z12) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate == null) {
                            if (unicastProcessor != null) {
                                this.window = null;
                                unicastProcessor.onComplete();
                            }
                            cVar.onComplete();
                            return;
                        }
                        if (unicastProcessor != null) {
                            this.window = null;
                            unicastProcessor.onError(terminate);
                        }
                        cVar.onError(terminate);
                        return;
                    } else if (z12) {
                        this.emitted = j11;
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else if (poll != NEXT_WINDOW) {
                        unicastProcessor.onNext(poll);
                    } else {
                        if (unicastProcessor != null) {
                            this.window = null;
                            unicastProcessor.onComplete();
                        }
                        if (!this.stopWindows.get()) {
                            UnicastProcessor<T> o11 = UnicastProcessor.o(this.capacityHint, this);
                            this.window = o11;
                            this.windows.getAndIncrement();
                            if (j11 != this.requested.get()) {
                                j11++;
                                s sVar = new s(o11);
                                cVar.onNext(sVar);
                                if (sVar.m()) {
                                    o11.onComplete();
                                }
                            } else {
                                SubscriptionHelper.cancel(this.upstream);
                                this.boundarySubscriber.dispose();
                                atomicThrowable.tryAddThrowableOrReport(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                this.done = true;
                            }
                        }
                    }
                } else {
                    mpscLinkedQueue.clear();
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onError(terminate2);
                    }
                    cVar.onError(terminate2);
                    return;
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }
    }

    public void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
    }

    public void innerError(Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.boundarySubscriber.dispose();
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this.upstream, dVar, Long.MAX_VALUE);
    }

    public void request(long j11) {
        b.a(this.requested, j11);
    }

    public void run() {
        if (this.windows.decrementAndGet() == 0) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }
}
