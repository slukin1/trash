package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;

final class FlowableCreate$LatestAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<T> queue = new AtomicReference<>();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableCreate$LatestAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    public void drain() {
        int i11;
        boolean z11;
        if (this.wip.getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            AtomicReference<T> atomicReference = this.queue;
            int i12 = 1;
            do {
                long j11 = get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    z11 = false;
                    if (i11 == 0) {
                        break;
                    } else if (isCancelled()) {
                        atomicReference.lazySet((Object) null);
                        return;
                    } else {
                        boolean z12 = this.done;
                        T andSet = atomicReference.getAndSet((Object) null);
                        boolean z13 = andSet == null;
                        if (z12 && z13) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                errorDownstream(th2);
                                return;
                            } else {
                                completeDownstream();
                                return;
                            }
                        } else if (z13) {
                            break;
                        } else {
                            cVar.onNext(andSet);
                            j12++;
                        }
                    }
                }
                if (i11 == 0) {
                    if (isCancelled()) {
                        atomicReference.lazySet((Object) null);
                        return;
                    }
                    boolean z14 = this.done;
                    if (atomicReference.get() == null) {
                        z11 = true;
                    }
                    if (z14 && z11) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            errorDownstream(th3);
                            return;
                        } else {
                            completeDownstream();
                            return;
                        }
                    }
                }
                if (j12 != 0) {
                    b.e(this, j12);
                }
                i12 = this.wip.addAndGet(-i12);
            } while (i12 != 0);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (!this.done && !isCancelled()) {
            if (t11 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
                return;
            }
            this.queue.set(t11);
            drain();
        }
    }

    public void onRequested() {
        drain();
    }

    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet((Object) null);
        }
    }

    public boolean signalError(Throwable th2) {
        if (this.done || isCancelled()) {
            return false;
        }
        this.error = th2;
        this.done = true;
        drain();
        return true;
    }
}
