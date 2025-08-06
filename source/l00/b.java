package l00;

import h00.m;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> implements m<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<io.reactivex.rxjava3.disposables.b> f57993b;

    /* renamed from: c  reason: collision with root package name */
    public final m<? super T> f57994c;

    public b(AtomicReference<io.reactivex.rxjava3.disposables.b> atomicReference, m<? super T> mVar) {
        this.f57993b = atomicReference;
        this.f57994c = mVar;
    }

    public void onError(Throwable th2) {
        this.f57994c.onError(th2);
    }

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        DisposableHelper.replace(this.f57993b, bVar);
    }

    public void onSuccess(T t11) {
        this.f57994c.onSuccess(t11);
    }
}
