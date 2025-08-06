package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableTimeout$TimeoutObserver<T> extends AtomicLong implements k<T>, b, j {
    private static final long serialVersionUID = 3764492702657003550L;
    public final k<? super T> downstream;
    public final h<? super T, ? extends j<?>> itemTimeoutIndicator;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<b> upstream = new AtomicReference<>();

    public ObservableTimeout$TimeoutObserver(k<? super T> kVar, h<? super T, ? extends j<?>> hVar) {
        this.downstream = kVar;
        this.itemTimeoutIndicator = hVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        long j11 = get();
        if (j11 != Long.MAX_VALUE) {
            long j12 = 1 + j11;
            if (compareAndSet(j11, j12)) {
                b bVar = (b) this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.downstream.onNext(t11);
                try {
                    Object apply = this.itemTimeoutIndicator.apply(t11);
                    Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    j jVar = (j) apply;
                    ObservableTimeout$TimeoutConsumer observableTimeout$TimeoutConsumer = new ObservableTimeout$TimeoutConsumer(j12, this);
                    if (this.task.replace(observableTimeout$TimeoutConsumer)) {
                        jVar.subscribe(observableTimeout$TimeoutConsumer);
                    }
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    this.upstream.get().dispose();
                    getAndSet(Long.MAX_VALUE);
                    this.downstream.onError(th2);
                }
            }
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void onTimeout(long j11) {
        if (compareAndSet(j11, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(new TimeoutException());
        }
    }

    public void onTimeoutError(long j11, Throwable th2) {
        if (compareAndSet(j11, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th2);
            return;
        }
        a.n(th2);
    }

    public void startFirstTimeout(j<?> jVar) {
        if (jVar != null) {
            ObservableTimeout$TimeoutConsumer observableTimeout$TimeoutConsumer = new ObservableTimeout$TimeoutConsumer(0, this);
            if (this.task.replace(observableTimeout$TimeoutConsumer)) {
                jVar.subscribe(observableTimeout$TimeoutConsumer);
            }
        }
    }
}
