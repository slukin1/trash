package io.reactivex.rxjava3.internal.disposables;

import h00.a;
import h00.f;
import h00.k;
import h00.m;
import k00.b;

public enum EmptyDisposable implements b<Object> {
    INSTANCE,
    NEVER;

    public static void complete(k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onComplete();
    }

    public static void error(Throwable th2, k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onError(th2);
    }

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }

    public int requestFusion(int i11) {
        return i11 & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(f<?> fVar) {
        fVar.onSubscribe(INSTANCE);
        fVar.onComplete();
    }

    public static void error(Throwable th2, a aVar) {
        aVar.onSubscribe(INSTANCE);
        aVar.onError(th2);
    }

    public static void complete(a aVar) {
        aVar.onSubscribe(INSTANCE);
        aVar.onComplete();
    }

    public static void error(Throwable th2, m<?> mVar) {
        mVar.onSubscribe(INSTANCE);
        mVar.onError(th2);
    }

    public static void error(Throwable th2, f<?> fVar) {
        fVar.onSubscribe(INSTANCE);
        fVar.onError(th2);
    }
}
