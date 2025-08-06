package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k00.f;
import m00.c;
import z20.b;
import z20.d;

final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements e<T>, d, c<R> {
    private static final long serialVersionUID = -4255299542215038287L;
    public volatile boolean cancelled;
    public volatile InnerQueuedSubscriber<R> current;
    public volatile boolean done;
    public final z20.c<? super R> downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final h<? super T, ? extends b<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public final AtomicLong requested = new AtomicLong();
    public final a<InnerQueuedSubscriber<R>> subscribers;
    public d upstream;

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(z20.c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i11, int i12, ErrorMode errorMode2) {
        this.downstream = cVar;
        this.mapper = hVar;
        this.maxConcurrency = i11;
        this.prefetch = i12;
        this.errorMode = errorMode2;
        this.subscribers = new a<>(Math.min(i12, i11));
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            this.errors.tryTerminateAndReport();
            drainAndCancel();
        }
    }

    public void cancelAll() {
        InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
        this.current = null;
        if (innerQueuedSubscriber != null) {
            innerQueuedSubscriber.cancel();
        }
        while (true) {
            InnerQueuedSubscriber poll = this.subscribers.poll();
            if (poll != null) {
                poll.cancel();
            } else {
                return;
            }
        }
    }

    public void drain() {
        InnerQueuedSubscriber<R> innerQueuedSubscriber;
        int i11;
        long j11;
        long j12;
        boolean z11;
        f<R> queue;
        int i12;
        if (getAndIncrement() == 0) {
            InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
            z20.c<? super R> cVar = this.downstream;
            ErrorMode errorMode2 = this.errorMode;
            int i13 = 1;
            while (true) {
                long j13 = this.requested.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else if (errorMode2 == ErrorMode.END || ((Throwable) this.errors.get()) == null) {
                    boolean z12 = this.done;
                    innerQueuedSubscriber = this.subscribers.poll();
                    if (z12 && innerQueuedSubscriber == null) {
                        this.errors.tryTerminateConsumer((z20.c<?>) this.downstream);
                        return;
                    } else if (innerQueuedSubscriber != null) {
                        this.current = innerQueuedSubscriber;
                    }
                } else {
                    cancelAll();
                    this.errors.tryTerminateConsumer((z20.c<?>) this.downstream);
                    return;
                }
                if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                    i11 = i13;
                    z11 = false;
                    j12 = 0;
                    j11 = 0;
                } else {
                    j11 = 0;
                    while (true) {
                        i12 = (j11 > j13 ? 1 : (j11 == j13 ? 0 : -1));
                        i11 = i13;
                        if (i12 == 0) {
                            break;
                        } else if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                            boolean isDone = innerQueuedSubscriber.isDone();
                            try {
                                R poll = queue.poll();
                                boolean z13 = poll == null;
                                if (isDone && z13) {
                                    this.current = null;
                                    this.upstream.request(1);
                                    innerQueuedSubscriber = null;
                                    z11 = true;
                                    break;
                                } else if (z13) {
                                    break;
                                } else {
                                    cVar.onNext(poll);
                                    j11++;
                                    innerQueuedSubscriber.request(1);
                                    i13 = i11;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                io.reactivex.rxjava3.exceptions.a.b(th3);
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                cVar.onError(th3);
                                return;
                            }
                        } else {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            this.errors.tryTerminateConsumer((z20.c<?>) this.downstream);
                            return;
                        }
                    }
                    z11 = false;
                    if (i12 == 0) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                            boolean isDone2 = innerQueuedSubscriber.isDone();
                            boolean isEmpty = queue.isEmpty();
                            if (isDone2 && isEmpty) {
                                this.current = null;
                                this.upstream.request(1);
                                innerQueuedSubscriber = null;
                                z11 = true;
                            }
                        } else {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            this.errors.tryTerminateConsumer((z20.c<?>) this.downstream);
                            return;
                        }
                    }
                    j12 = 0;
                }
                if (!(j11 == j12 || j13 == Long.MAX_VALUE)) {
                    this.requested.addAndGet(-j11);
                }
                if (z11) {
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                    i13 = i11;
                } else {
                    i13 = addAndGet(-i11);
                    if (i13 != 0) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void drainAndCancel() {
        if (getAndIncrement() == 0) {
            do {
                cancelAll();
            } while (decrementAndGet() != 0);
        }
    }

    public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        drain();
    }

    public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            innerQueuedSubscriber.setDone();
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            drain();
        }
    }

    public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r11) {
        if (innerQueuedSubscriber.queue().offer(r11)) {
            drain();
            return;
        }
        innerQueuedSubscriber.cancel();
        innerError(innerQueuedSubscriber, new MissingBackpressureException());
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    public void onNext(T t11) {
        try {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            b bVar = (b) apply;
            InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
            if (!this.cancelled) {
                this.subscribers.offer(innerQueuedSubscriber);
                bVar.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            int i11 = this.maxConcurrency;
            dVar.request(i11 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i11);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            drain();
        }
    }
}
