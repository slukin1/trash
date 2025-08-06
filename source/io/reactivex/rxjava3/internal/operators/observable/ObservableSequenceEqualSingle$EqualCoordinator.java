package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.queue.a;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements b {
    private static final long serialVersionUID = -6178010334400373240L;
    public volatile boolean cancelled;
    public final d<? super T, ? super T> comparer;
    public final m<? super Boolean> downstream;
    public final j<? extends T> first;
    public final i<T>[] observers;
    public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
    public final j<? extends T> second;

    /* renamed from: v1  reason: collision with root package name */
    public T f55558v1;

    /* renamed from: v2  reason: collision with root package name */
    public T f55559v2;

    public ObservableSequenceEqualSingle$EqualCoordinator(m<? super Boolean> mVar, int i11, j<? extends T> jVar, j<? extends T> jVar2, d<? super T, ? super T> dVar) {
        this.downstream = mVar;
        this.first = jVar;
        this.second = jVar2;
        this.comparer = dVar;
        i<T>[] iVarArr = new i[2];
        this.observers = iVarArr;
        iVarArr[0] = new i<>(this, 0, i11);
        iVarArr[1] = new i<>(this, 1, i11);
    }

    public void cancel(a<T> aVar, a<T> aVar2) {
        this.cancelled = true;
        aVar.clear();
        aVar2.clear();
    }

    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                i<T>[] iVarArr = this.observers;
                iVarArr[0].f55579c.clear();
                iVarArr[1].f55579c.clear();
            }
        }
    }

    public void drain() {
        Throwable th2;
        Throwable th3;
        if (getAndIncrement() == 0) {
            i<T>[] iVarArr = this.observers;
            i<T> iVar = iVarArr[0];
            a<T> aVar = iVar.f55579c;
            i<T> iVar2 = iVarArr[1];
            a<T> aVar2 = iVar2.f55579c;
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = iVar.f55581e;
                if (!z11 || (th3 = iVar.f55582f) == null) {
                    boolean z12 = iVar2.f55581e;
                    if (!z12 || (th2 = iVar2.f55582f) == null) {
                        if (this.f55558v1 == null) {
                            this.f55558v1 = aVar.poll();
                        }
                        boolean z13 = this.f55558v1 == null;
                        if (this.f55559v2 == null) {
                            this.f55559v2 = aVar2.poll();
                        }
                        T t11 = this.f55559v2;
                        boolean z14 = t11 == null;
                        if (z11 && z12 && z13 && z14) {
                            this.downstream.onSuccess(Boolean.TRUE);
                            return;
                        } else if (!z11 || !z12 || z13 == z14) {
                            if (!z13 && !z14) {
                                try {
                                    if (!this.comparer.a(this.f55558v1, t11)) {
                                        cancel(aVar, aVar2);
                                        this.downstream.onSuccess(Boolean.FALSE);
                                        return;
                                    }
                                    this.f55558v1 = null;
                                    this.f55559v2 = null;
                                } catch (Throwable th4) {
                                    io.reactivex.rxjava3.exceptions.a.b(th4);
                                    cancel(aVar, aVar2);
                                    this.downstream.onError(th4);
                                    return;
                                }
                            }
                            if ((z13 || z14) && (i11 = addAndGet(-i11)) == 0) {
                                return;
                            }
                        } else {
                            cancel(aVar, aVar2);
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        }
                    } else {
                        cancel(aVar, aVar2);
                        this.downstream.onError(th2);
                        return;
                    }
                } else {
                    cancel(aVar, aVar2);
                    this.downstream.onError(th3);
                    return;
                }
            }
            aVar.clear();
            aVar2.clear();
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean setDisposable(b bVar, int i11) {
        return this.resources.setResource(i11, bVar);
    }

    public void subscribe() {
        i<T>[] iVarArr = this.observers;
        this.first.subscribe(iVarArr[0]);
        this.second.subscribe(iVarArr[1]);
    }
}
