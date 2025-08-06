package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.f;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableCreate$Emitter extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -2467358622224974244L;
    public final a downstream;

    public CompletableCreate$Emitter(a aVar) {
        this.downstream = aVar;
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
            o00.a.n(th2);
        }
    }

    public void setCancellable(f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    public void setDisposable(b bVar) {
        DisposableHelper.set(this, bVar);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{CompletableCreate$Emitter.class.getSimpleName(), super.toString()});
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
