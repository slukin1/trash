package io.reactivex.rxjava3.internal.observers;

import h00.a;
import h00.f;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.CountDownLatch;

public final class BlockingMultiObserver<T> extends CountDownLatch implements m<T>, a, f<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f55462b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55463c;

    /* renamed from: d  reason: collision with root package name */
    public b f55464d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f55465e;

    public BlockingMultiObserver() {
        super(1);
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th2) {
        this.f55463c = th2;
        countDown();
    }

    public void onSubscribe(b bVar) {
        this.f55464d = bVar;
        if (this.f55465e) {
            bVar.dispose();
        }
    }

    public void onSuccess(T t11) {
        this.f55462b = t11;
        countDown();
    }
}
