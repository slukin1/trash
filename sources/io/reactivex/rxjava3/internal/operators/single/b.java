package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.a;

public final class b<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f55609b;

    public b(T t11) {
        this.f55609b = t11;
    }

    public void f(m<? super T> mVar) {
        mVar.onSubscribe(a.a());
        mVar.onSuccess(this.f55609b);
    }
}
