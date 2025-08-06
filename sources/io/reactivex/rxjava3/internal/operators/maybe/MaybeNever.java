package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class MaybeNever extends Maybe<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final MaybeNever f55540b = new MaybeNever();

    public void b(f<? super Object> fVar) {
        fVar.onSubscribe(EmptyDisposable.NEVER);
    }
}
