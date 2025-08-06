package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import java.util.concurrent.atomic.AtomicInteger;
import k00.b;

public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements b<T>, Runnable {
    public static final int FUSED = 1;
    public static final int ON_COMPLETE = 3;
    public static final int ON_NEXT = 2;
    public static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    public final k<? super T> observer;
    public final T value;

    public ObservableScalarXMap$ScalarDisposable(k<? super T> kVar, T t11) {
        this.observer = kVar;
        this.value = t11;
    }

    public void clear() {
        lazySet(3);
    }

    public void dispose() {
        set(3);
    }

    public boolean isDisposed() {
        return get() == 3;
    }

    public boolean isEmpty() {
        return get() != 1;
    }

    public boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 1) {
            return null;
        }
        lazySet(3);
        return this.value;
    }

    public int requestFusion(int i11) {
        if ((i11 & 1) == 0) {
            return 0;
        }
        lazySet(1);
        return 1;
    }

    public void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            this.observer.onNext(this.value);
            if (get() == 2) {
                lazySet(3);
                this.observer.onComplete();
            }
        }
    }

    public boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
