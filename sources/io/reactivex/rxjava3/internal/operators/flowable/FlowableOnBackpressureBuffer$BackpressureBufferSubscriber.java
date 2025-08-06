package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.a;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

final class FlowableOnBackpressureBuffer$BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements e<T> {
    private static final long serialVersionUID = -2514538129242366402L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public final c<? super T> downstream;
    public Throwable error;
    public final a onOverflow;
    public boolean outputFused;
    public final k00.e<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;

    public FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(c<? super T> cVar, int i11, boolean z11, boolean z12, a aVar) {
        k00.e<T> eVar;
        this.downstream = cVar;
        this.onOverflow = aVar;
        this.delayError = z12;
        if (z11) {
            eVar = new io.reactivex.rxjava3.internal.queue.a<>(i11);
        } else {
            eVar = new SpscArrayQueue<>(i11);
        }
        this.queue = eVar;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            if (!this.outputFused && getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, c<? super T> cVar) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!this.delayError) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    cVar.onError(th2);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    cVar.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                Throwable th3 = this.error;
                if (th3 != null) {
                    cVar.onError(th3);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        int i11;
        if (getAndIncrement() == 0) {
            k00.e<T> eVar = this.queue;
            c<? super T> cVar = this.downstream;
            int i12 = 1;
            while (!checkTerminated(this.done, eVar.isEmpty(), cVar)) {
                long j11 = this.requested.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    T poll = eVar.poll();
                    boolean z12 = poll == null;
                    if (!checkTerminated(z11, z12, cVar)) {
                        if (z12) {
                            break;
                        }
                        cVar.onNext(poll);
                        j12++;
                    } else {
                        return;
                    }
                }
                if (i11 != 0 || !checkTerminated(this.done, eVar.isEmpty(), cVar)) {
                    if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                        this.requested.addAndGet(-j12);
                    }
                    i12 = addAndGet(-i12);
                    if (i12 == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        if (this.outputFused) {
            this.downstream.onComplete();
        } else {
            drain();
        }
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        if (this.outputFused) {
            this.downstream.onError(th2);
        } else {
            drain();
        }
    }

    public void onNext(T t11) {
        if (!this.queue.offer(t11)) {
            this.upstream.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                missingBackpressureException.initCause(th2);
            }
            onError(missingBackpressureException);
        } else if (this.outputFused) {
            this.downstream.onNext(null);
        } else {
            drain();
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public T poll() {
        return this.queue.poll();
    }

    public void request(long j11) {
        if (!this.outputFused && SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }

    public int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
