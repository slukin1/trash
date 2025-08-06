package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class MaybeCreate$Emitter<T> extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -2467358622224974244L;
    public final f<? super T> downstream;

    public MaybeCreate$Emitter(f<? super T> fVar) {
        this.downstream = fVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        b bVar;
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper && (bVar = (b) getAndSet(disposableHelper)) != disposableHelper) {
            try {
                this.downstream.onComplete();
            } finally {
                if (bVar != null) {
                    bVar.dispose();
                }
            }
        }
    }

    public void onError(Throwable th2) {
        if (!tryOnError(th2)) {
            a.n(th2);
        }
    }

    public void onSuccess(T t11) {
        b bVar;
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper && (bVar = (b) getAndSet(disposableHelper)) != disposableHelper) {
            if (t11 == null) {
                try {
                    this.downstream.onError(ExceptionHelper.b("onSuccess called with a null value."));
                } catch (Throwable th2) {
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    throw th2;
                }
            } else {
                this.downstream.onSuccess(t11);
            }
            if (bVar != null) {
                bVar.dispose();
            }
        }
    }

    public void setCancellable(j00.f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    public void setDisposable(b bVar) {
        DisposableHelper.set(this, bVar);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{MaybeCreate$Emitter.class.getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable th2) {
        b bVar;
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        }
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj == disposableHelper || (bVar = (b) getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        try {
            this.downstream.onError(th2);
        } finally {
            if (bVar != null) {
                bVar.dispose();
            }
        }
    }
}
