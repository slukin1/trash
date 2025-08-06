package io.reactivex.rxjava3.internal.util;

import h00.a;
import h00.e;
import h00.f;
import h00.k;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import z20.c;
import z20.d;

public enum EmptyComponent implements e<Object>, k<Object>, f<Object>, m<Object>, a, d, b {
    INSTANCE;

    public static <T> k<T> asObserver() {
        return INSTANCE;
    }

    public static <T> c<T> asSubscriber() {
        return INSTANCE;
    }

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onError(Throwable th2) {
        o00.a.n(th2);
    }

    public void onNext(Object obj) {
    }

    public void onSubscribe(b bVar) {
        bVar.dispose();
    }

    public void onSuccess(Object obj) {
    }

    public void request(long j11) {
    }

    public void onSubscribe(d dVar) {
        dVar.cancel();
    }
}
