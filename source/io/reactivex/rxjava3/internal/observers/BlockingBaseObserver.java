package io.reactivex.rxjava3.internal.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements k<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public T f55455b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55456c;

    /* renamed from: d  reason: collision with root package name */
    public b f55457d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f55458e;

    public BlockingBaseObserver() {
        super(1);
    }

    public final void dispose() {
        this.f55458e = true;
        b bVar = this.f55457d;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f55458e;
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(b bVar) {
        this.f55457d = bVar;
        if (this.f55458e) {
            bVar.dispose();
        }
    }
}
