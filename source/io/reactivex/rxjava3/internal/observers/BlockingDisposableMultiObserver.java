package io.reactivex.rxjava3.internal.observers;

import h00.a;
import h00.f;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.CountDownLatch;

public final class BlockingDisposableMultiObserver<T> extends CountDownLatch implements f<T>, m<T>, a, b {

    /* renamed from: b  reason: collision with root package name */
    public T f55459b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55460c;

    /* renamed from: d  reason: collision with root package name */
    public final SequentialDisposable f55461d = new SequentialDisposable();

    public BlockingDisposableMultiObserver() {
        super(1);
    }

    public void dispose() {
        this.f55461d.dispose();
        countDown();
    }

    public boolean isDisposed() {
        return this.f55461d.isDisposed();
    }

    public void onComplete() {
        this.f55461d.lazySet(io.reactivex.rxjava3.disposables.a.a());
        countDown();
    }

    public void onError(Throwable th2) {
        this.f55460c = th2;
        this.f55461d.lazySet(io.reactivex.rxjava3.disposables.a.a());
        countDown();
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.f55461d, bVar);
    }

    public void onSuccess(T t11) {
        this.f55459b = t11;
        this.f55461d.lazySet(io.reactivex.rxjava3.disposables.a.a());
        countDown();
    }
}
