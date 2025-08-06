package io.reactivex.rxjava3.internal.jdk8;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

final class ObservableCollectWithCollector$CollectorObserver<T, A, R> extends DeferredScalarDisposable<R> implements k<T> {
    private static final long serialVersionUID = -229544830565448758L;
    public final BiConsumer<A, T> accumulator;
    public A container;
    public boolean done;
    public final Function<A, R> finisher;
    public b upstream;

    public ObservableCollectWithCollector$CollectorObserver(k<? super R> kVar, A a11, BiConsumer<A, T> biConsumer, Function<A, R> function) {
        super(kVar);
        this.container = a11;
        this.accumulator = biConsumer;
        this.finisher = function;
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.upstream = DisposableHelper.DISPOSED;
            A a11 = this.container;
            this.container = null;
            try {
                R apply = this.finisher.apply(a11);
                Objects.requireNonNull(apply, "The finisher returned a null value");
                complete(apply);
            } catch (Throwable th2) {
                a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.done = true;
        this.upstream = DisposableHelper.DISPOSED;
        this.container = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            try {
                this.accumulator.accept(this.container, t11);
            } catch (Throwable th2) {
                a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
