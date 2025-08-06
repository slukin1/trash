package io.reactivex.rxjava3.internal.operators.completable;

import h00.a;
import h00.b;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements a {
    private static final long serialVersionUID = -7965400327305809232L;
    public final a downstream;

    /* renamed from: sd  reason: collision with root package name */
    public final SequentialDisposable f55473sd = new SequentialDisposable();
    public final Iterator<? extends b> sources;

    public CompletableConcatIterable$ConcatInnerObserver(a aVar, Iterator<? extends b> it2) {
        this.downstream = aVar;
        this.sources = it2;
    }

    public void next() {
        if (!this.f55473sd.isDisposed() && getAndIncrement() == 0) {
            Iterator<? extends b> it2 = this.sources;
            while (!this.f55473sd.isDisposed()) {
                try {
                    if (!it2.hasNext()) {
                        this.downstream.onComplete();
                        return;
                    }
                    try {
                        Object next = it2.next();
                        Objects.requireNonNull(next, "The CompletableSource returned is null");
                        ((b) next).a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        this.downstream.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    this.downstream.onError(th3);
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
        this.f55473sd.replace(bVar);
    }
}
