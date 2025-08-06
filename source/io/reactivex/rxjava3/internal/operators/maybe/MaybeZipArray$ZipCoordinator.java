package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import o00.a;

final class MaybeZipArray$ZipCoordinator<T, R> extends AtomicInteger implements b {
    private static final long serialVersionUID = -5556924161382950569L;
    public final f<? super R> downstream;
    public final MaybeZipArray$ZipMaybeObserver<T>[] observers;
    public final Object[] values;
    public final h<? super Object[], ? extends R> zipper;

    public MaybeZipArray$ZipCoordinator(f<? super R> fVar, int i11, h<? super Object[], ? extends R> hVar) {
        super(i11);
        this.downstream = fVar;
        this.zipper = hVar;
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = new MaybeZipArray$ZipMaybeObserver[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            maybeZipArray$ZipMaybeObserverArr[i12] = new MaybeZipArray$ZipMaybeObserver<>(this, i12);
        }
        this.observers = maybeZipArray$ZipMaybeObserverArr;
        this.values = new Object[i11];
    }

    public void dispose() {
        if (getAndSet(0) > 0) {
            for (MaybeZipArray$ZipMaybeObserver<T> dispose : this.observers) {
                dispose.dispose();
            }
        }
    }

    public void disposeExcept(int i11) {
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = this.observers;
        int length = maybeZipArray$ZipMaybeObserverArr.length;
        for (int i12 = 0; i12 < i11; i12++) {
            maybeZipArray$ZipMaybeObserverArr[i12].dispose();
        }
        while (true) {
            i11++;
            if (i11 < length) {
                maybeZipArray$ZipMaybeObserverArr[i11].dispose();
            } else {
                return;
            }
        }
    }

    public void innerComplete(int i11) {
        if (getAndSet(0) > 0) {
            disposeExcept(i11);
            this.downstream.onComplete();
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
