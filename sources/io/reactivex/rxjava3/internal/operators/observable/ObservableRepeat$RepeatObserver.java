package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableRepeat$RepeatObserver<T> extends AtomicInteger implements k<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final k<? super T> downstream;
    public long remaining;

    /* renamed from: sd  reason: collision with root package name */
    public final SequentialDisposable f55555sd;
    public final j<? extends T> source;

    public ObservableRepeat$RepeatObserver(k<? super T> kVar, long j11, SequentialDisposable sequentialDisposable, j<? extends T> jVar) {
        this.downstream = kVar;
        this.f55555sd = sequentialDisposable;
        this.source = jVar;
        this.remaining = j11;
    }

    public void onComplete() {
        long j11 = this.remaining;
        if (j11 != Long.MAX_VALUE) {
            this.remaining = j11 - 1;
        }
        if (j11 != 0) {
            subscribeNext();
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        this.f55555sd.replace(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i11 = 1;
            while (!this.f55555sd.isDisposed()) {
                this.source.subscribe(this);
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }
}
