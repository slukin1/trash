package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicBoolean;

final class ObservableUsing$UsingObserver<T, D> extends AtomicBoolean implements k<T>, b {
    private static final long serialVersionUID = 5904473792286235046L;
    public final g<? super D> disposer;
    public final k<? super T> downstream;
    public final boolean eager;
    public final D resource;
    public b upstream;

    public ObservableUsing$UsingObserver(k<? super T> kVar, D d11, g<? super D> gVar, boolean z11) {
        this.downstream = kVar;
        this.resource = d11;
        this.disposer = gVar;
        this.eager = z11;
    }

    public void dispose() {
        if (this.eager) {
            disposeResource();
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            return;
        }
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeResource();
    }

    public void disposeResource() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept(this.resource);
            } catch (Throwable th2) {
                a.b(th2);
                o00.a.n(th2);
            }
        }
    }

    public boolean isDisposed() {
        return get();
    }

    public void onComplete() {
        if (this.eager) {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.upstream.dispose();
            this.downstream.onComplete();
            return;
        }
        this.downstream.onComplete();
        this.upstream.dispose();
        disposeResource();
    }

    public void onError(Throwable th2) {
        if (this.eager) {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th3) {
                    a.b(th3);
                    th2 = new CompositeException(th2, th3);
                }
            }
            this.upstream.dispose();
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onError(th2);
        this.upstream.dispose();
        disposeResource();
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
