package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import j00.e;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableRepeatUntil$RepeatUntilObserver<T> extends AtomicInteger implements k<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    public final k<? super T> downstream;
    public final j<? extends T> source;
    public final e stop;
    public final SequentialDisposable upstream;

    public ObservableRepeatUntil$RepeatUntilObserver(k<? super T> kVar, e eVar, SequentialDisposable sequentialDisposable, j<? extends T> jVar) {
        this.downstream = kVar;
        this.upstream = sequentialDisposable;
        this.source = jVar;
        this.stop = eVar;
    }

    public void onComplete() {
        try {
            if (this.stop.getAsBoolean()) {
                this.downstream.onComplete();
            } else {
                subscribeNext();
            }
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
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
            do {
                this.source.subscribe(this);
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }
}
