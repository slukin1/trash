package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import h00.b;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements a {
    private static final long serialVersionUID = -7965400327305809232L;
    public final a downstream;
    public int index;

    /* renamed from: sd  reason: collision with root package name */
    public final SequentialDisposable f55472sd = new SequentialDisposable();
    public final b[] sources;

    public CompletableConcatArray$ConcatInnerObserver(a aVar, b[] bVarArr) {
        this.downstream = aVar;
        this.sources = bVarArr;
    }

    public void next() {
        if (!this.f55472sd.isDisposed() && getAndIncrement() == 0) {
            b[] bVarArr = this.sources;
            while (!this.f55472sd.isDisposed()) {
                int i11 = this.index;
                this.index = i11 + 1;
                if (i11 == bVarArr.length) {
                    this.downstream.onComplete();
                    return;
                }
                bVarArr[i11].a(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void onComplete() {
        next();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        this.f55472sd.replace(bVar);
    }
}
