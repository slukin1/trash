package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class ObservableTakeLastTimed$TakeLastTimedObserver<T> extends AtomicBoolean implements k<T>, b {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final long count;
    public final boolean delayError;
    public final k<? super T> downstream;
    public Throwable error;
    public final a<Object> queue;
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;
    public b upstream;

    public ObservableTakeLastTimed$TakeLastTimedObserver(k<? super T> kVar, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler2, int i11, boolean z11) {
        this.downstream = kVar;
        this.count = j11;
        this.time = j12;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.queue = new a<>(i11);
        this.delayError = z11;
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        Throwable th2;
        if (compareAndSet(false, true)) {
            k<? super T> kVar = this.downstream;
            a<Object> aVar = this.queue;
            boolean z11 = this.delayError;
            long b11 = this.scheduler.b(this.unit) - this.time;
            while (!this.cancelled) {
                if (z11 || (th2 = this.error) == null) {
                    Object poll = aVar.poll();
                    if (poll == null) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            kVar.onError(th3);
                            return;
                        } else {
                            kVar.onComplete();
                            return;
                        }
                    } else {
                        Object poll2 = aVar.poll();
                        if (((Long) poll).longValue() >= b11) {
                            kVar.onNext(poll2);
                        }
                    }
                } else {
                    aVar.clear();
                    kVar.onError(th2);
                    return;
                }
            }
            aVar.clear();
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        drain();
    }

    public void onNext(T t11) {
        a<Object> aVar = this.queue;
        long b11 = this.scheduler.b(this.unit);
        long j11 = this.time;
        long j12 = this.count;
        boolean z11 = j12 == Long.MAX_VALUE;
        aVar.l(Long.valueOf(b11), t11);
        while (!aVar.isEmpty()) {
            if (((Long) aVar.peek()).longValue() <= b11 - j11 || (!z11 && ((long) (aVar.n() >> 1)) > j12)) {
                aVar.poll();
                aVar.poll();
            } else {
                return;
            }
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
