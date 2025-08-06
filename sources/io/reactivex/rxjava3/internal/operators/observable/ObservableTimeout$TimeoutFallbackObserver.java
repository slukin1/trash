package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class ObservableTimeout$TimeoutFallbackObserver<T> extends AtomicReference<b> implements k<T>, b, j {
    private static final long serialVersionUID = -7508389464265974549L;
    public final k<? super T> downstream;
    public j<? extends T> fallback;
    public final AtomicLong index;
    public final h<? super T, ? extends j<?>> itemTimeoutIndicator;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<b> upstream;

    public ObservableTimeout$TimeoutFallbackObserver(k<? super T> kVar, h<? super T, ? extends j<?>> hVar, j<? extends T> jVar) {
        this.downstream = kVar;
        this.itemTimeoutIndicator = hVar;
        this.fallback = jVar;
        this.index = new AtomicLong();
        this.upstream = new AtomicReference<>();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.task.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.task.dispose();
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        long j11 = this.index.get();
        if (j11 != Long.MAX_VALUE) {
            long j12 = 1 + j11;
            if (this.index.compareAndSet(j11, j12)) {
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
                    this.index.getAndSet(Long.MAX_VALUE);
                    this.downstream.onError(th2);
                }
            }
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void onTimeout(long j11) {
        if (this.index.compareAndSet(j11, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.upstream);
            j<? extends T> jVar = this.fallback;
            this.fallback = null;
            jVar.subscribe(new k(this.downstream, this));
        }
    }

    public void onTimeoutError(long j11, Throwable th2) {
        if (this.index.compareAndSet(j11, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this);
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
