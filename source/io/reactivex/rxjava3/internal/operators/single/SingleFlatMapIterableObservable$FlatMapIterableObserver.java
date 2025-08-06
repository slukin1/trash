package io.reactivex.rxjava3.internal.operators.single;

import h00.k;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import j00.h;
import java.util.Iterator;
import java.util.Objects;

final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements m<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    public volatile boolean cancelled;
    public final k<? super R> downstream;

    /* renamed from: it  reason: collision with root package name */
    public volatile Iterator<? extends R> f55603it;
    public final h<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;
    public b upstream;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(k<? super R> kVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
        this.downstream = kVar;
        this.mapper = hVar;
    }

    public void clear() {
        this.f55603it = null;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        return this.f55603it == null;
    }

    public void onError(Throwable th2) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        k<? super R> kVar = this.downstream;
        try {
            Iterator<? extends R> it2 = ((Iterable) this.mapper.apply(t11)).iterator();
            if (!it2.hasNext()) {
                kVar.onComplete();
            } else if (this.outputFused) {
                this.f55603it = it2;
                kVar.onNext(null);
                kVar.onComplete();
            } else {
                while (!this.cancelled) {
                    try {
                        kVar.onNext(it2.next());
                        if (!this.cancelled) {
                            try {
                                if (!it2.hasNext()) {
                                    kVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th2) {
                                a.b(th2);
                                kVar.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        a.b(th3);
                        kVar.onError(th3);
                        return;
                    }
                }
            }
        } catch (Throwable th4) {
            a.b(th4);
            this.downstream.onError(th4);
        }
    }

    public R poll() {
        Iterator<? extends R> it2 = this.f55603it;
        if (it2 == null) {
            return null;
        }
        R next = it2.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it2.hasNext()) {
            this.f55603it = null;
        }
        return next;
    }

    public int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
