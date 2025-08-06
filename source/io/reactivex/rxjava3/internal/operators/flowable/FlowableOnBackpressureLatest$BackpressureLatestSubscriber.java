package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = 163080509307634843L;
    public volatile boolean cancelled;
    public final AtomicReference<T> current = new AtomicReference<>();
    public volatile boolean done;
    public final c<? super T> downstream;
    public Throwable error;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;

    public FlowableOnBackpressureLatest$BackpressureLatestSubscriber(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet((Object) null);
            }
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, c<?> cVar, AtomicReference<T> atomicReference) {
        if (this.cancelled) {
            atomicReference.lazySet((Object) null);
            return true;
        } else if (!z11) {
            return false;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                atomicReference.lazySet((Object) null);
                cVar.onError(th2);
                return true;
            } else if (!z12) {
                return false;
            } else {
                cVar.onComplete();
                return true;
            }
        }
    }

    public void drain() {
        boolean z11;
        if (getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            AtomicLong atomicLong = this.requested;
            AtomicReference<T> atomicReference = this.current;
            int i11 = 1;
            do {
                long j11 = 0;
                while (true) {
                    z11 = false;
                    if (j11 == atomicLong.get()) {
                        break;
                    }
                    boolean z12 = this.done;
                    T andSet = atomicReference.getAndSet((Object) null);
                    boolean z13 = andSet == null;
                    if (!checkTerminated(z12, z13, cVar, atomicReference)) {
                        if (z13) {
                            break;
                        }
                        cVar.onNext(andSet);
                        j11++;
                    } else {
                        return;
                    }
                }
                if (j11 == atomicLong.get()) {
                    boolean z14 = this.done;
                    if (atomicReference.get() == null) {
                        z11 = true;
                    }
                    if (checkTerminated(z14, z11, cVar, atomicReference)) {
                        return;
                    }
                }
                if (j11 != 0) {
                    b.e(atomicLong, j11);
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.current.lazySet(t11);
        drain();
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }
}
