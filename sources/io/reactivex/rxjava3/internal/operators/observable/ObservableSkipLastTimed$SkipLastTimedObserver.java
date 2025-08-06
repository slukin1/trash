package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableSkipLastTimed$SkipLastTimedObserver<T> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public final k<? super T> downstream;
    public Throwable error;
    public final a<Object> queue;
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;
    public b upstream;

    public ObservableSkipLastTimed$SkipLastTimedObserver(k<? super T> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i11, boolean z11) {
        this.downstream = kVar;
        this.time = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.queue = new a<>(i11);
        this.delayError = z11;
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super T> kVar = this.downstream;
            a<Object> aVar = this.queue;
            boolean z11 = this.delayError;
            TimeUnit timeUnit = this.unit;
            Scheduler scheduler2 = this.scheduler;
            long j11 = this.time;
            int i11 = 1;
            while (!this.cancelled) {
                boolean z12 = this.done;
                Long l11 = (Long) aVar.peek();
                boolean z13 = l11 == null;
                long b11 = scheduler2.b(timeUnit);
                if (!z13 && l11.longValue() > b11 - j11) {
                    z13 = true;
                }
                if (z12) {
                    if (!z11) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.queue.clear();
                            kVar.onError(th2);
                            return;
                        } else if (z13) {
                            kVar.onComplete();
                            return;
                        }
                    } else if (z13) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            kVar.onError(th3);
                            return;
                        } else {
                            kVar.onComplete();
                            return;
                        }
                    }
                }
                if (z13) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    aVar.poll();
                    kVar.onNext(aVar.poll());
                }
            }
            this.queue.clear();
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
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
        this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), t11);
        drain();
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
