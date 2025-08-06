package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import h00.b;
import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.d;

final class CompletableConcat$CompletableConcatSubscriber extends AtomicInteger implements e<b>, io.reactivex.rxjava3.disposables.b {
    private static final long serialVersionUID = 9032184911934499404L;
    public volatile boolean active;
    public int consumed;
    public volatile boolean done;
    public final a downstream;
    public final ConcatInnerObserver inner = new ConcatInnerObserver(this);
    public final int limit;
    public final AtomicBoolean once = new AtomicBoolean();
    public final int prefetch;
    public f<b> queue;
    public int sourceFused;
    public d upstream;

    public static final class ConcatInnerObserver extends AtomicReference<io.reactivex.rxjava3.disposables.b> implements a {
        private static final long serialVersionUID = -5454794857847146511L;
        public final CompletableConcat$CompletableConcatSubscriber parent;

        public ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber completableConcat$CompletableConcatSubscriber) {
            this.parent = completableConcat$CompletableConcatSubscriber;
        }

        public void onComplete() {
            this.parent.innerComplete();
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public CompletableConcat$CompletableConcatSubscriber(a aVar, int i11) {
        this.downstream = aVar;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.inner);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z11 = this.done;
                    try {
                        b poll = this.queue.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            this.downstream.onComplete();
                            return;
                        } else if (!z12) {
                            this.active = true;
                            poll.a(this.inner);
                            request();
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        innerError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            this.upstream.cancel();
            this.downstream.onError(th2);
            return;
        }
        o00.a.n(th2);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((io.reactivex.rxjava3.disposables.b) this.inner.get());
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.inner);
            this.downstream.onError(th2);
            return;
        }
        o00.a.n(th2);
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            int i11 = this.prefetch;
            long j11 = i11 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i11;
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceFused = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceFused = requestFusion;
                    this.queue = dVar2;
                    this.downstream.onSubscribe(this);
                    dVar.request(j11);
                    return;
                }
            }
            if (this.prefetch == Integer.MAX_VALUE) {
                this.queue = new io.reactivex.rxjava3.internal.queue.a(Flowable.b());
            } else {
                this.queue = new SpscArrayQueue(this.prefetch);
            }
            this.downstream.onSubscribe(this);
            dVar.request(j11);
        }
    }

    public void request() {
        if (this.sourceFused != 1) {
            int i11 = this.consumed + 1;
            if (i11 == this.limit) {
                this.consumed = 0;
                this.upstream.request((long) i11);
                return;
            }
            this.consumed = i11;
        }
    }

    public void onNext(b bVar) {
        if (this.sourceFused != 0 || this.queue.offer(bVar)) {
            drain();
        } else {
            onError(new MissingBackpressureException());
        }
    }
}
