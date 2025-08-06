package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.g;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeUsing$UsingObserver<T, D> extends AtomicReference<Object> implements f<T>, b {
    private static final long serialVersionUID = -674404550052917487L;
    public final g<? super D> disposer;
    public final f<? super T> downstream;
    public final boolean eager;
    public b upstream;

    public MaybeUsing$UsingObserver(f<? super T> fVar, D d11, g<? super D> gVar, boolean z11) {
        super(d11);
        this.downstream = fVar;
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

    public void onComplete() {
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
        this.downstream.onComplete();
        if (!this.eager) {
            disposeResource();
        }
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
