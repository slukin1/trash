package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import z20.c;

final class FlowableCreate$BufferAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final a<T> queue;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableCreate$BufferAsyncEmitter(c<? super T> cVar, int i11) {
        super(cVar);
        this.queue = new a<>(i11);
    }

    public void drain() {
        int i11;
        if (this.wip.getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            a<T> aVar = this.queue;
            int i12 = 1;
            do {
                long j11 = get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (isCancelled()) {
                        aVar.clear();
                        return;
                    } else {
                        boolean z11 = this.done;
                        T poll = aVar.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                errorDownstream(th2);
                                return;
                            } else {
                                completeDownstream();
                                return;
                            }
                        } else if (z12) {
                            break;
                        } else {
                            cVar.onNext(poll);
                            j12++;
                        }
                    }
                }
                if (i11 == 0) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z13 = this.done;
                    boolean isEmpty = aVar.isEmpty();
                    if (z13 && isEmpty) {
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
            this.queue.offer(t11);
            drain();
        }
    }

    public void onRequested() {
        drain();
    }

    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
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
