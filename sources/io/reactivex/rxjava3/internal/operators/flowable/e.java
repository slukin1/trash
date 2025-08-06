package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import z20.b;
import z20.c;

public final class e<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final b<? extends T> f55515c;

    public e(b<? extends T> bVar) {
        this.f55515c = bVar;
    }

    public void j(c<? super T> cVar) {
        this.f55515c.subscribe(cVar);
    }
}
