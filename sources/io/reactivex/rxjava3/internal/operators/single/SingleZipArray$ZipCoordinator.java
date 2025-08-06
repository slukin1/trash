package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.disposables.b;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import o00.a;

final class SingleZipArray$ZipCoordinator<T, R> extends AtomicInteger implements b {
    private static final long serialVersionUID = -5556924161382950569L;
    public final m<? super R> downstream;
    public final SingleZipArray$ZipSingleObserver<T>[] observers;
    public final Object[] values;
    public final h<? super Object[], ? extends R> zipper;

    public SingleZipArray$ZipCoordinator(m<? super R> mVar, int i11, h<? super Object[], ? extends R> hVar) {
        super(i11);
        this.downstream = mVar;
        this.zipper = hVar;
        SingleZipArray$ZipSingleObserver<T>[] singleZipArray$ZipSingleObserverArr = new SingleZipArray$ZipSingleObserver[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            singleZipArray$ZipSingleObserverArr[i12] = new SingleZipArray$ZipSingleObserver<>(this, i12);
        }
        this.observers = singleZipArray$ZipSingleObserverArr;
        this.values = new Object[i11];
    }

    public void dispose() {
        if (getAndSet(0) > 0) {
            for (SingleZipArray$ZipSingleObserver<T> dispose : this.observers) {
                dispose.dispose();
            }
        }
    }

    public void disposeExcept(int i11) {
        SingleZipArray$ZipSingleObserver<T>[] singleZipArray$ZipSingleObserverArr = this.observers;
        int length = singleZipArray$ZipSingleObserverArr.length;
        for (int i12 = 0; i12 < i11; i12++) {
            singleZipArray$ZipSingleObserverArr[i12].dispose();
        }
        while (true) {
            i11++;
            if (i11 < length) {
                singleZipArray$ZipSingleObserverArr[i11].dispose();
            } else {
                return;
            }
        }
    }

    public void innerError(Throwable th2, int i11) {
        if (getAndSet(0) > 0) {
            disposeExcept(i11);
            this.downstream.onError(th2);
            return;
        }
        a.n(th2);
    }

    public void innerSuccess(T t11, int i11) {
        this.values[i11] = t11;
        if (decrementAndGet() == 0) {
            try {
                Object apply = this.zipper.apply(this.values);
                Objects.requireNonNull(apply, "The zipper returned a null value");
                this.downstream.onSuccess(apply);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public boolean isDisposed() {
        return get() <= 0;
    }
}
