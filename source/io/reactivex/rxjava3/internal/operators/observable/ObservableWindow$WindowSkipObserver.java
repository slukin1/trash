package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableWindow$WindowSkipObserver<T> extends AtomicBoolean implements k<T>, b, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    public volatile boolean cancelled;
    public final int capacityHint;
    public final long count;
    public final k<? super Observable<T>> downstream;
    public long firstEmission;
    public long index;
    public final long skip;
    public b upstream;
    public final ArrayDeque<UnicastSubject<T>> windows;
    public final AtomicInteger wip = new AtomicInteger();

    public ObservableWindow$WindowSkipObserver(k<? super Observable<T>> kVar, long j11, long j12, int i11) {
        this.downstream = kVar;
        this.count = j11;
        this.skip = j12;
        this.capacityHint = i11;
        this.windows = new ArrayDeque<>();
    }

    public void dispose() {
        this.cancelled = true;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onError(th2);
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        o oVar;
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        long j11 = this.index;
        long j12 = this.skip;
        if (j11 % j12 != 0 || this.cancelled) {
            oVar = null;
        } else {
            this.wip.getAndIncrement();
            UnicastSubject d11 = UnicastSubject.d(this.capacityHint, this);
            oVar = new o(d11);
            arrayDeque.offer(d11);
            this.downstream.onNext(oVar);
        }
        long j13 = this.firstEmission + 1;
        Iterator<UnicastSubject<T>> it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            it2.next().onNext(t11);
        }
        if (j13 >= this.count) {
            arrayDeque.poll().onComplete();
            if (!arrayDeque.isEmpty() || !this.cancelled) {
                this.firstEmission = j13 - j12;
            } else {
                this.upstream.dispose();
                return;
            }
        } else {
            this.firstEmission = j13;
        }
        this.index = j11 + 1;
        if (oVar != null && oVar.c()) {
            oVar.f55589b.onComplete();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        if (this.wip.decrementAndGet() == 0 && this.cancelled) {
            this.upstream.dispose();
        }
    }
}
