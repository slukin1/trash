package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ObservableSampleWithObservable$SampleMainObserver<T> extends AtomicReference<T> implements k<T>, b {
    private static final long serialVersionUID = -3517602651313910099L;
    public final k<? super T> downstream;
    public final AtomicReference<b> other = new AtomicReference<>();
    public final j<?> sampler;
    public b upstream;

    public ObservableSampleWithObservable$SampleMainObserver(k<? super T> kVar, j<?> jVar) {
        this.downstream = kVar;
        this.sampler = jVar;
    }

    public void complete() {
        this.upstream.dispose();
        completion();
    }

    public abstract void completion();

    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.upstream.dispose();
    }

    public void emit() {
        Object andSet = getAndSet((Object) null);
        if (andSet != null) {
            this.downstream.onNext(andSet);
        }
    }

    public void error(Throwable th2) {
        this.upstream.dispose();
        this.downstream.onError(th2);
    }

    public boolean isDisposed() {
        return this.other.get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        completion();
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        lazySet(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            if (this.other.get() == null) {
                this.sampler.subscribe(new g(this));
            }
        }
    }

    public abstract void run();

    public boolean setOther(b bVar) {
        return DisposableHelper.setOnce(this.other, bVar);
    }
}
