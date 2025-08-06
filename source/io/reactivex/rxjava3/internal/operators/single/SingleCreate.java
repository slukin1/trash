package io.reactivex.rxjava3.internal.operators.single;

import h00.l;
import h00.m;
import h00.n;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.f;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

public final class SingleCreate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final n<T> f55599b;

    public static final class Emitter<T> extends AtomicReference<b> implements l<T>, b {
        private static final long serialVersionUID = -2467358622224974244L;
        public final m<? super T> downstream;

        public Emitter(m<? super T> mVar) {
            this.downstream = mVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
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

        public void setCancellable(f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        public void setDisposable(b bVar) {
            DisposableHelper.set(this, bVar);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{Emitter.class.getSimpleName(), super.toString()});
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

    public SingleCreate(n<T> nVar) {
        this.f55599b = nVar;
    }

    public void f(m<? super T> mVar) {
        Emitter emitter = new Emitter(mVar);
        mVar.onSubscribe(emitter);
        try {
            this.f55599b.a(emitter);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            emitter.onError(th2);
        }
    }
}
