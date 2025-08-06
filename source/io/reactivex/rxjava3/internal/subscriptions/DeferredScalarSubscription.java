package io.reactivex.rxjava3.internal.subscriptions;

import z20.c;

public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    public static final int CANCELLED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    public final c<? super T> downstream;
    public T value;

    public DeferredScalarSubscription(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t11) {
        int i11 = get();
        while (i11 != 8) {
            if ((i11 & -3) == 0) {
                if (i11 == 2) {
                    lazySet(3);
                    c<? super T> cVar = this.downstream;
                    cVar.onNext(t11);
                    if (get() != 4) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                }
                this.value = t11;
                if (!compareAndSet(0, 1)) {
                    i11 = get();
                    if (i11 == 4) {
                        this.value = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.value = t11;
        lazySet(16);
        c<? super T> cVar2 = this.downstream;
        cVar2.onNext(t11);
        if (get() != 4) {
            cVar2.onComplete();
        }
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t11 = this.value;
        this.value = null;
        return t11;
    }

    public final void request(long j11) {
        T t11;
        if (SubscriptionHelper.validate(j11)) {
            do {
                int i11 = get();
                if ((i11 & -2) == 0) {
                    if (i11 == 1) {
                        if (compareAndSet(1, 3) && (t11 = this.value) != null) {
                            this.value = null;
                            c<? super T> cVar = this.downstream;
                            cVar.onNext(t11);
                            if (get() != 4) {
                                cVar.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
