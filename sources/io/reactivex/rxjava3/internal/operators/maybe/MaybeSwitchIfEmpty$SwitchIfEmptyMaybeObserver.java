package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = -2223459372976438024L;
    public final f<? super T> downstream;
    public final g<? extends T> other;

    public static final class a<T> implements f<T> {

        /* renamed from: b  reason: collision with root package name */
        public final f<? super T> f55543b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<b> f55544c;

        public a(f<? super T> fVar, AtomicReference<b> atomicReference) {
            this.f55543b = fVar;
            this.f55544c = atomicReference;
        }

        public void onComplete() {
            this.f55543b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f55543b.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f55544c, bVar);
        }

        public void onSuccess(T t11) {
            this.f55543b.onSuccess(t11);
        }
    }

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(f<? super T> fVar, g<? extends T> gVar) {
        this.downstream = fVar;
        this.other = gVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        b bVar = (b) get();
        if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, (Object) null)) {
            this.other.a(new a(this.downstream, this));
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.downstream.onSuccess(t11);
    }
}
