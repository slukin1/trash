package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import j00.a;
import k00.b;

final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements k<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    public final k<? super T> downstream;
    public final a onFinally;

    /* renamed from: qd  reason: collision with root package name */
    public b<T> f55553qd;
    public boolean syncFused;
    public io.reactivex.rxjava3.disposables.b upstream;

    public ObservableDoFinally$DoFinallyObserver(k<? super T> kVar, a aVar) {
        this.downstream = kVar;
        this.onFinally = aVar;
    }

    public void clear() {
        this.f55553qd.clear();
    }

    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return this.f55553qd.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        runFinally();
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof b) {
                this.f55553qd = (b) bVar;
            }
            this.downstream.onSubscribe(this);
        }
    }

    public T poll() throws Throwable {
        T poll = this.f55553qd.poll();
        if (poll == null && this.syncFused) {
            runFinally();
        }
        return poll;
    }

    public int requestFusion(int i11) {
        b<T> bVar = this.f55553qd;
        boolean z11 = false;
        if (bVar == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i11);
        if (requestFusion != 0) {
            if (requestFusion == 1) {
                z11 = true;
            }
            this.syncFused = z11;
        }
        return requestFusion;
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                o00.a.n(th2);
            }
        }
    }
}
