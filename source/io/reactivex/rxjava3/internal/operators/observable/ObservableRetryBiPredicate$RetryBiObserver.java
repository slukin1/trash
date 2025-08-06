package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableRetryBiPredicate$RetryBiObserver<T> extends AtomicInteger implements k<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final k<? super T> downstream;
    public final d<? super Integer, ? super Throwable> predicate;
    public int retries;
    public final j<? extends T> source;
    public final SequentialDisposable upstream;

    public ObservableRetryBiPredicate$RetryBiObserver(k<? super T> kVar, d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, j<? extends T> jVar) {
        this.downstream = kVar;
        this.upstream = sequentialDisposable;
        this.source = jVar;
        this.predicate = dVar;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        try {
            d<? super Integer, ? super Throwable> dVar = this.predicate;
            int i11 = this.retries + 1;
            this.retries = i11;
            if (!dVar.a(Integer.valueOf(i11), th2)) {
                this.downstream.onError(th2);
            } else {
                subscribeNext();
            }
        } catch (Throwable th3) {
            a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        this.downstream.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        this.upstream.replace(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i11 = 1;
            while (!this.upstream.isDisposed()) {
                this.source.subscribe(this);
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }
}
