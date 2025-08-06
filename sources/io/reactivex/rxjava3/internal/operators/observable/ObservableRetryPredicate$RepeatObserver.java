package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import j00.j;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableRetryPredicate$RepeatObserver<T> extends AtomicInteger implements k<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final k<? super T> downstream;
    public final j<? super Throwable> predicate;
    public long remaining;
    public final h00.j<? extends T> source;
    public final SequentialDisposable upstream;

    public ObservableRetryPredicate$RepeatObserver(k<? super T> kVar, long j11, j<? super Throwable> jVar, SequentialDisposable sequentialDisposable, h00.j<? extends T> jVar2) {
        this.downstream = kVar;
        this.upstream = sequentialDisposable;
        this.source = jVar2;
        this.predicate = jVar;
        this.remaining = j11;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        long j11 = this.remaining;
        if (j11 != Long.MAX_VALUE) {
            this.remaining = j11 - 1;
        }
        if (j11 == 0) {
            this.downstream.onError(th2);
            return;
        }
        try {
            if (!this.predicate.test(th2)) {
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
