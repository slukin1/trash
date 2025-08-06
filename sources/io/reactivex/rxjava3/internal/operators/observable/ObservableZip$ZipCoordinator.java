package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import j00.h;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableZip$ZipCoordinator<T, R> extends AtomicInteger implements b {
    private static final long serialVersionUID = 2983708048395377667L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public final k<? super R> downstream;
    public final p<T, R>[] observers;
    public final T[] row;
    public final h<? super Object[], ? extends R> zipper;

    public ObservableZip$ZipCoordinator(k<? super R> kVar, h<? super Object[], ? extends R> hVar, int i11, boolean z11) {
        this.downstream = kVar;
        this.zipper = hVar;
        this.observers = new p[i11];
        this.row = new Object[i11];
        this.delayError = z11;
    }

    public void cancel() {
        clear();
        cancelSources();
    }

    public void cancelSources() {
        for (p<T, R> a11 : this.observers) {
            a11.a();
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12, k<? super R> kVar, boolean z13, p<?, ?> pVar) {
        if (this.cancelled) {
            cancel();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!z13) {
                Throwable th2 = pVar.f55594e;
                if (th2 != null) {
                    this.cancelled = true;
                    cancel();
                    kVar.onError(th2);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    this.cancelled = true;
                    cancel();
                    kVar.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                Throwable th3 = pVar.f55594e;
                this.cancelled = true;
                cancel();
                if (th3 != null) {
                    kVar.onError(th3);
                } else {
                    kVar.onComplete();
                }
                return true;
            }
        }
    }

    public void clear() {
        for (p<T, R> pVar : this.observers) {
            pVar.f55592c.clear();
        }
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }
    }

    public void drain() {
        Throwable th2;
        if (getAndIncrement() == 0) {
            p<T, R>[] pVarArr = this.observers;
            k<? super R> kVar = this.downstream;
            T[] tArr = this.row;
            boolean z11 = this.delayError;
            int i11 = 1;
            while (true) {
                int i12 = 0;
                int i13 = 0;
                for (p<T, R> pVar : pVarArr) {
                    if (tArr[i13] == null) {
                        boolean z12 = pVar.f55593d;
                        T poll = pVar.f55592c.poll();
                        boolean z13 = poll == null;
                        if (!checkTerminated(z12, z13, kVar, z11, pVar)) {
                            if (!z13) {
                                tArr[i13] = poll;
                            } else {
                                i12++;
                            }
                        } else {
                            return;
                        }
                    } else if (pVar.f55593d && !z11 && (th2 = pVar.f55594e) != null) {
                        this.cancelled = true;
                        cancel();
                        kVar.onError(th2);
                        return;
                    }
                    i13++;
                }
                if (i12 != 0) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    try {
                        Object apply = this.zipper.apply(tArr.clone());
                        Objects.requireNonNull(apply, "The zipper returned a null value");
                        kVar.onNext(apply);
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th3) {
                        a.b(th3);
                        cancel();
                        kVar.onError(th3);
                        return;
                    }
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(j<? extends T>[] jVarArr, int i11) {
        p<T, R>[] pVarArr = this.observers;
        int length = pVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            pVarArr[i12] = new p<>(this, i11);
        }
        lazySet(0);
        this.downstream.onSubscribe(this);
        for (int i13 = 0; i13 < length && !this.cancelled; i13++) {
            jVarArr[i13].subscribe(pVarArr[i13]);
        }
    }
}
