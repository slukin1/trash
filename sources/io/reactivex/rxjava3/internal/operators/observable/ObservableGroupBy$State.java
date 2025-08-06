package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableGroupBy$State<T, K> extends AtomicInteger implements b, j<T> {
    public static final int ABANDONED = 2;
    public static final int ABANDONED_HAS_SUBSCRIBER = 3;
    public static final int FRESH = 0;
    public static final int HAS_SUBSCRIBER = 1;
    private static final long serialVersionUID = -3852313036005250360L;
    public final AtomicReference<k<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicInteger once = new AtomicInteger();
    public final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    public final a<T> queue;

    public ObservableGroupBy$State(int i11, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k11, boolean z11) {
        this.queue = new a<>(i11);
        this.parent = observableGroupBy$GroupByObserver;
        this.key = k11;
        this.delayError = z11;
    }

    public void cancelParent() {
        if ((this.once.get() & 2) == 0) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, k<? super T> kVar, boolean z13) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.actual.lazySet((Object) null);
            cancelParent();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!z13) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    this.actual.lazySet((Object) null);
                    kVar.onError(th2);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    this.actual.lazySet((Object) null);
                    kVar.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                Throwable th3 = this.error;
                this.actual.lazySet((Object) null);
                if (th3 != null) {
                    kVar.onError(th3);
                } else {
                    kVar.onComplete();
                }
                return true;
            }
        }
    }

    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.actual.lazySet((Object) null);
            cancelParent();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            a<T> aVar = this.queue;
            boolean z11 = this.delayError;
            k kVar = this.actual.get();
            int i11 = 1;
            while (true) {
                if (kVar != null) {
                    while (true) {
                        boolean z12 = this.done;
                        T poll = aVar.poll();
                        boolean z13 = poll == null;
                        if (!checkTerminated(z12, z13, kVar, z11)) {
                            if (z13) {
                                break;
                            }
                            kVar.onNext(poll);
                        } else {
                            return;
                        }
                    }
                }
                i11 = addAndGet(-i11);
                if (i11 != 0) {
                    if (kVar == null) {
                        kVar = this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public void subscribe(k<? super T> kVar) {
        int i11;
        do {
            i11 = this.once.get();
            if ((i11 & 1) != 0) {
                EmptyDisposable.error((Throwable) new IllegalStateException("Only one Observer allowed!"), (k<?>) kVar);
                return;
            }
        } while (!this.once.compareAndSet(i11, i11 | 1));
        kVar.onSubscribe(this);
        this.actual.lazySet(kVar);
        if (this.cancelled.get()) {
            this.actual.lazySet((Object) null);
        } else {
            drain();
        }
    }

    public boolean tryAbandon() {
        return this.once.get() == 0 && this.once.compareAndSet(0, 2);
    }
}
