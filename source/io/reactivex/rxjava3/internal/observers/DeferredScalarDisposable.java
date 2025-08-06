package io.reactivex.rxjava3.internal.observers;

import h00.k;
import o00.a;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    public static final int DISPOSED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    public final k<? super T> downstream;
    public T value;

    public DeferredScalarDisposable(k<? super T> kVar) {
        this.downstream = kVar;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t11) {
        int i11 = get();
        if ((i11 & 54) == 0) {
            k<? super T> kVar = this.downstream;
            if (i11 == 8) {
                this.value = t11;
                lazySet(16);
                kVar.onNext(null);
            } else {
                lazySet(2);
                kVar.onNext(t11);
            }
            if (get() != 4) {
                kVar.onComplete();
            }
        }
    }

    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th2) {
        if ((get() & 54) != 0) {
            a.n(th2);
            return;
        }
        lazySet(2);
        this.downstream.onError(th2);
    }

    public final boolean isDisposed() {
        return get() == 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        T t11 = this.value;
        this.value = null;
        lazySet(32);
        return t11;
    }

    public final int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.downstream.onComplete();
        }
    }
}
