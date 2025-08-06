package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.queue.a;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableSequenceEqual$EqualCoordinator<T> extends AtomicInteger implements b {
    private static final long serialVersionUID = -6178010334400373240L;
    public volatile boolean cancelled;
    public final d<? super T, ? super T> comparer;
    public final k<? super Boolean> downstream;
    public final j<? extends T> first;
    public final h<T>[] observers;
    public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
    public final j<? extends T> second;

    /* renamed from: v1  reason: collision with root package name */
    public T f55556v1;

    /* renamed from: v2  reason: collision with root package name */
    public T f55557v2;

    public ObservableSequenceEqual$EqualCoordinator(k<? super Boolean> kVar, int i11, j<? extends T> jVar, j<? extends T> jVar2, d<? super T, ? super T> dVar) {
        this.downstream = kVar;
        this.first = jVar;
        this.second = jVar2;
        this.comparer = dVar;
        h<T>[] hVarArr = new h[2];
        this.observers = hVarArr;
        hVarArr[0] = new h<>(this, 0, i11);
        hVarArr[1] = new h<>(this, 1, i11);
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
                h<T>[] hVarArr = this.observers;
                hVarArr[0].f55574c.clear();
                hVarArr[1].f55574c.clear();
            }
        }
    }

    public void drain() {
        Throwable th2;
        Throwable th3;
        if (getAndIncrement() == 0) {
            h<T>[] hVarArr = this.observers;
            h<T> hVar = hVarArr[0];
            a<T> aVar = hVar.f55574c;
            h<T> hVar2 = hVarArr[1];
            a<T> aVar2 = hVar2.f55574c;
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = hVar.f55576e;
                if (!z11 || (th3 = hVar.f55577f) == null) {
                    boolean z12 = hVar2.f55576e;
                    if (!z12 || (th2 = hVar2.f55577f) == null) {
                        if (this.f55556v1 == null) {
                            this.f55556v1 = aVar.poll();
                        }
                        boolean z13 = this.f55556v1 == null;
                        if (this.f55557v2 == null) {
                            this.f55557v2 = aVar2.poll();
                        }
                        T t11 = this.f55557v2;
                        boolean z14 = t11 == null;
                        if (z11 && z12 && z13 && z14) {
                            this.downstream.onNext(Boolean.TRUE);
                            this.downstream.onComplete();
                            return;
                        } else if (!z11 || !z12 || z13 == z14) {
                            if (!z13 && !z14) {
                                try {
                                    if (!this.comparer.a(this.f55556v1, t11)) {
                                        cancel(aVar, aVar2);
                                        this.downstream.onNext(Boolean.FALSE);
                                        this.downstream.onComplete();
                                        return;
                                    }
                                    this.f55556v1 = null;
                                    this.f55557v2 = null;
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
                            this.downstream.onNext(Boolean.FALSE);
                            this.downstream.onComplete();
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
        h<T>[] hVarArr = this.observers;
        this.first.subscribe(hVarArr[0]);
        this.second.subscribe(hVarArr[1]);
    }
}
