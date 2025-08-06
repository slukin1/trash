package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.d;

final class FlowableScanSeed$ScanSeedSubscriber<T, R> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -1776795561228106469L;
    public final c<R, ? super T, R> accumulator;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final z20.c<? super R> downstream;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final k00.e<R> queue;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;
    public R value;

    public FlowableScanSeed$ScanSeedSubscriber(z20.c<? super R> cVar, c<R, ? super T, R> cVar2, R r11, int i11) {
        this.downstream = cVar;
        this.accumulator = cVar2;
        this.value = r11;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i11);
        this.queue = spscArrayQueue;
        spscArrayQueue.offer(r11);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        int i11;
        Throwable th2;
        if (getAndIncrement() == 0) {
            z20.c<? super R> cVar = this.downstream;
            k00.e<R> eVar = this.queue;
            int i12 = this.limit;
            int i13 = this.consumed;
            int i14 = 1;
            do {
                long j11 = this.requested.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.cancelled) {
                        eVar.clear();
                        return;
                    } else {
                        boolean z11 = this.done;
                        if (!z11 || (th2 = this.error) == null) {
                            R poll = eVar.poll();
                            boolean z12 = poll == null;
                            if (z11 && z12) {
                                cVar.onComplete();
                                return;
                            } else if (z12) {
                                break;
                            } else {
                                cVar.onNext(poll);
                                j12++;
                                i13++;
                                if (i13 == i12) {
                                    this.upstream.request((long) i12);
                                    i13 = 0;
                                }
                            }
                        } else {
                            eVar.clear();
                            cVar.onError(th2);
                            return;
                        }
                    }
                }
                if (i11 == 0 && this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        eVar.clear();
                        cVar.onError(th3);
                        return;
                    } else if (eVar.isEmpty()) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (j12 != 0) {
                    b.e(this.requested, j12);
                }
                this.consumed = i13;
                i14 = addAndGet(-i14);
            } while (i14 != 0);
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                R apply = this.accumulator.apply(this.value, t11);
                Objects.requireNonNull(apply, "The accumulator returned a null value");
                this.value = apply;
                this.queue.offer(apply);
                drain();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request((long) (this.prefetch - 1));
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }
}
