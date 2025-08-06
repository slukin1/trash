package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import j00.k;

public final class MaybeEmpty extends Maybe<Object> implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final MaybeEmpty f55536b = new MaybeEmpty();

    public void b(f<? super Object> fVar) {
        EmptyDisposable.complete((f<?>) fVar);
    }

    public Object get() {
        return null;
    }
}
