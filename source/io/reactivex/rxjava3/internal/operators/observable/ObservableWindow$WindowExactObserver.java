package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableWindow$WindowExactObserver<T> extends AtomicInteger implements k<T>, b, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    public volatile boolean cancelled;
    public final int capacityHint;
    public final long count;
    public final k<? super Observable<T>> downstream;
    public long size;
    public b upstream;
    public UnicastSubject<T> window;

    public ObservableWindow$WindowExactObserver(k<? super Observable<T>> kVar, long j11, int i11) {
        this.downstream = kVar;
        this.count = j11;
        this.capacityHint = i11;
    }

    public void dispose() {
        this.cancelled = true;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onError(th2);
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        o oVar;
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null || this.cancelled) {
            oVar = null;
        } else {
            unicastSubject = UnicastSubject.d(this.capacityHint, this);
            this.window = unicastSubject;
            oVar = new o(unicastSubject);
            this.downstream.onNext(oVar);
        }
        if (unicastSubject != null) {
            unicastSubject.onNext(t11);
            long j11 = this.size + 1;
            this.size = j11;
            if (j11 >= this.count) {
                this.size = 0;
                this.window = null;
                unicastSubject.onComplete();
                if (this.cancelled) {
                    this.upstream.dispose();
                }
            }
            if (oVar != null && oVar.c()) {
                unicastSubject.onComplete();
                this.window = null;
            }
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        if (this.cancelled) {
            this.upstream.dispose();
        }
    }
}
