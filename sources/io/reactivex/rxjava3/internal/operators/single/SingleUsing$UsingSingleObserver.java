package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicReference;

final class SingleUsing$UsingSingleObserver<T, U> extends AtomicReference<Object> implements m<T>, b {
    private static final long serialVersionUID = -5331524057054083935L;
    public final g<? super U> disposer;
    public final m<? super T> downstream;
    public final boolean eager;
    public b upstream;

    public SingleUsing$UsingSingleObserver(m<? super T> mVar, U u11, boolean z11, g<? super U> gVar) {
        super(u11);
        this.downstream = mVar;
        this.eager = z11;
        this.disposer = gVar;
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
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th2) {
                a.b(th2);
                o00.a.n(th2);
            }
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable th2) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th3) {
                    a.b(th3);
                    th2 = new CompositeException(th2, th3);
                }
            } else {
                return;
            }
        }
        this.downstream.onError(th2);
        if (!this.eager) {
            disposeResource();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            } else {
                return;
            }
        }
        this.downstream.onSuccess(t11);
        if (!this.eager) {
            disposeResource();
        }
    }
}
