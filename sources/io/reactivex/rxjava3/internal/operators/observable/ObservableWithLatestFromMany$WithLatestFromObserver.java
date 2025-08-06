package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.e;
import j00.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import o00.a;

final class ObservableWithLatestFromMany$WithLatestFromObserver<T, R> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = 1577321883966341961L;
    public final h<? super Object[], R> combiner;
    public volatile boolean done;
    public final k<? super R> downstream;
    public final AtomicThrowable error;
    public final ObservableWithLatestFromMany$WithLatestInnerObserver[] observers;
    public final AtomicReference<b> upstream;
    public final AtomicReferenceArray<Object> values;

    public ObservableWithLatestFromMany$WithLatestFromObserver(k<? super R> kVar, h<? super Object[], R> hVar, int i11) {
        this.downstream = kVar;
        this.combiner = hVar;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = new ObservableWithLatestFromMany$WithLatestInnerObserver[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            observableWithLatestFromMany$WithLatestInnerObserverArr[i12] = new ObservableWithLatestFromMany$WithLatestInnerObserver(this, i12);
        }
        this.observers = observableWithLatestFromMany$WithLatestInnerObserverArr;
        this.values = new AtomicReferenceArray<>(i11);
        this.upstream = new AtomicReference<>();
        this.error = new AtomicThrowable();
    }

    public void cancelAllBut(int i11) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = this.observers;
        for (int i12 = 0; i12 < observableWithLatestFromMany$WithLatestInnerObserverArr.length; i12++) {
            if (i12 != i11) {
                observableWithLatestFromMany$WithLatestInnerObserverArr[i12].dispose();
            }
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        for (ObservableWithLatestFromMany$WithLatestInnerObserver dispose : this.observers) {
            dispose.dispose();
        }
    }

    public void innerComplete(int i11, boolean z11) {
        if (!z11) {
            this.done = true;
            cancelAllBut(i11);
            e.a(this.downstream, this, this.error);
        }
    }

    public void innerError(int i11, Throwable th2) {
        this.done = true;
        DisposableHelper.dispose(this.upstream);
        cancelAllBut(i11);
        e.c(this.downstream, th2, this, this.error);
    }

    public void innerNext(int i11, Object obj) {
        this.values.set(i11, obj);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            cancelAllBut(-1);
            e.a(this.downstream, this, this.error);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        e.c(this.downstream, th2, this, this.error);
    }

    public void onNext(T t11) {
        if (!this.done) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[(length + 1)];
            int i11 = 0;
            objArr[0] = t11;
            while (i11 < length) {
                Object obj = atomicReferenceArray.get(i11);
                if (obj != null) {
                    i11++;
                    objArr[i11] = obj;
                } else {
                    return;
                }
            }
            try {
                R apply = this.combiner.apply(objArr);
                Objects.requireNonNull(apply, "combiner returned a null value");
                e.e(this.downstream, apply, this, this.error);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                dispose();
                onError(th2);
            }
        }
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void subscribe(j<?>[] jVarArr, int i11) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = this.observers;
        AtomicReference<b> atomicReference = this.upstream;
        for (int i12 = 0; i12 < i11 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i12++) {
            jVarArr[i12].subscribe(observableWithLatestFromMany$WithLatestInnerObserverArr[i12]);
        }
    }
}
