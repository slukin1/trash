package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import java.util.concurrent.atomic.AtomicReference;

public final class p<T, R> implements k<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableZip$ZipCoordinator<T, R> f55591b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f55592c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f55593d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f55594e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<b> f55595f = new AtomicReference<>();

    public p(ObservableZip$ZipCoordinator<T, R> observableZip$ZipCoordinator, int i11) {
        this.f55591b = observableZip$ZipCoordinator;
        this.f55592c = new a<>(i11);
    }

    public void a() {
        DisposableHelper.dispose(this.f55595f);
    }

    public void onComplete() {
        this.f55593d = true;
        this.f55591b.drain();
    }

    public void onError(Throwable th2) {
        this.f55594e = th2;
        this.f55593d = true;
        this.f55591b.drain();
    }

    public void onNext(T t11) {
        this.f55592c.offer(t11);
        this.f55591b.drain();
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.f55595f, bVar);
    }
}
