package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<b> implements f<T>, b {
    private static final long serialVersionUID = 4603919676453758899L;
    public final m<? super T> downstream;
    public final o<? extends T> other;

    public static final class a<T> implements m<T> {

        /* renamed from: b  reason: collision with root package name */
        public final m<? super T> f55545b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<b> f55546c;

        public a(m<? super T> mVar, AtomicReference<b> atomicReference) {
            this.f55545b = mVar;
            this.f55546c = atomicReference;
        }

        public void onError(Throwable th2) {
            this.f55545b.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f55546c, bVar);
        }

        public void onSuccess(T t11) {
            this.f55545b.onSuccess(t11);
        }
    }

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(m<? super T> mVar, o<? extends T> oVar) {
        this.downstream = mVar;
        this.other = oVar;
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
