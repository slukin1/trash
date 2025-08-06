package io.reactivex.rxjava3.internal.operators.mixed;

import h00.e;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableConcatMapSingle$ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements e<T>, d {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_INACTIVE = 0;
    public static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final c<? super R> downstream;
    public long emitted;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
    public R item;
    public final h<? super T, ? extends o<? extends R>> mapper;
    public final int prefetch;
    public final k00.e<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public volatile int state;
    public d upstream;

    public static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements m<R> {
        private static final long serialVersionUID = -3051469169682093892L;
        public final FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> parent;

        public ConcatMapSingleObserver(FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> flowableConcatMapSingle$ConcatMapSingleSubscriber) {
            this.parent = flowableConcatMapSingle$ConcatMapSingleSubscriber;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        public void onSuccess(R r11) {
            this.parent.innerSuccess(r11);
        }
    }

    public FlowableConcatMapSingle$ConcatMapSingleSubscriber(c<? super R> cVar, h<? super T, ? extends o<? extends R>> hVar, int i11, ErrorMode errorMode2) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.prefetch = i11;
        this.errorMode = errorMode2;
        this.queue = new SpscArrayQueue(i11);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.inner.dispose();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue.clear();
            this.item = null;
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super R> cVar = this.downstream;
            ErrorMode errorMode2 = this.errorMode;
            k00.e<T> eVar = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicLong atomicLong = this.requested;
            int i11 = this.prefetch;
            int i12 = i11 - (i11 >> 1);
            int i13 = 1;
            while (true) {
                if (this.cancelled) {
                    eVar.clear();
                    this.item = null;
                } else {
                    int i14 = this.state;
                    if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i14 == 0))) {
                        if (i14 == 0) {
                            boolean z11 = this.done;
                            T poll = eVar.poll();
                            boolean z12 = poll == null;
                            if (z11 && z12) {
                                atomicThrowable.tryTerminateConsumer((c<?>) cVar);
                                return;
                            } else if (!z12) {
                                int i15 = this.consumed + 1;
                                if (i15 == i12) {
                                    this.consumed = 0;
                                    this.upstream.request((long) i12);
                                } else {
                                    this.consumed = i15;
                                }
                                try {
                                    Object apply = this.mapper.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                    o oVar = (o) apply;
                                    this.state = 1;
                                    oVar.a(this.inner);
                                } catch (Throwable th2) {
                                    a.b(th2);
                                    this.upstream.cancel();
                                    eVar.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th2);
                                    atomicThrowable.tryTerminateConsumer((c<?>) cVar);
                                    return;
                                }
                            }
                        } else if (i14 == 2) {
                            long j11 = this.emitted;
                            if (j11 != atomicLong.get()) {
                                R r11 = this.item;
                                this.item = null;
                                cVar.onNext(r11);
                                this.emitted = j11 + 1;
                                this.state = 0;
                            }
                        }
                    }
                }
                i13 = addAndGet(-i13);
                if (i13 == 0) {
                    return;
                }
            }
            eVar.clear();
            this.item = null;
            atomicThrowable.tryTerminateConsumer((c<?>) cVar);
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            this.state = 0;
            drain();
        }
    }

    public void innerSuccess(R r11) {
        this.item = r11;
        this.state = 2;
        drain();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
            }
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        if (!this.queue.offer(t11)) {
            this.upstream.cancel();
            onError(new MissingBackpressureException("queue full?!"));
            return;
        }
        drain();
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request((long) this.prefetch);
        }
    }

    public void request(long j11) {
        io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        drain();
    }
}
