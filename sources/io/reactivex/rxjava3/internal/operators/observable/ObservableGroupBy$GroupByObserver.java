package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import n00.a;

public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements k<T>, b {
    public static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    public final int bufferSize;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final boolean delayError;
    public final k<? super a<K, V>> downstream;
    public final Map<Object, d<K, V>> groups;
    public final h<? super T, ? extends K> keySelector;
    public b upstream;
    public final h<? super T, ? extends V> valueSelector;

    public ObservableGroupBy$GroupByObserver(k<? super a<K, V>> kVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i11, boolean z11) {
        this.downstream = kVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i11;
        this.delayError = z11;
        this.groups = new ConcurrentHashMap();
        lazySet(1);
    }

    public void cancel(K k11) {
        if (k11 == null) {
            k11 = NULL_KEY;
        }
        this.groups.remove(k11);
        if (decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        ArrayList<d> arrayList = new ArrayList<>(this.groups.values());
        this.groups.clear();
        for (d onComplete : arrayList) {
            onComplete.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        ArrayList<d> arrayList = new ArrayList<>(this.groups.values());
        this.groups.clear();
        for (d onError : arrayList) {
            onError.onError(th2);
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        Object obj;
        try {
            Object apply = this.keySelector.apply(t11);
            if (apply != null) {
                obj = apply;
            } else {
                obj = NULL_KEY;
            }
            d dVar = this.groups.get(obj);
            boolean z11 = false;
            if (dVar == null) {
                if (!this.cancelled.get()) {
                    dVar = d.c(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, dVar);
                    getAndIncrement();
                    z11 = true;
                } else {
                    return;
                }
            }
            try {
                Object apply2 = this.valueSelector.apply(t11);
                Objects.requireNonNull(apply2, "The value supplied is null");
                dVar.onNext(apply2);
                if (z11) {
                    this.downstream.onNext(dVar);
                    if (dVar.f55571c.tryAbandon()) {
                        cancel(apply);
                        dVar.onComplete();
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.upstream.dispose();
                if (z11) {
                    this.downstream.onNext(dVar);
                }
                onError(th2);
            }
        } catch (Throwable th3) {
            io.reactivex.rxjava3.exceptions.a.b(th3);
            this.upstream.dispose();
            onError(th3);
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
