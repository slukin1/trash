package io.reactivex.rxjava3.subscribers;

import h00.e;
import z20.d;

public abstract class DefaultSubscriber<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public d f55784b;

    public void a() {
        b(Long.MAX_VALUE);
    }

    public final void b(long j11) {
        d dVar = this.f55784b;
        if (dVar != null) {
            dVar.request(j11);
        }
    }

    public final void onSubscribe(d dVar) {
        if (io.reactivex.rxjava3.internal.util.d.f(this.f55784b, dVar, getClass())) {
            this.f55784b = dVar;
            a();
        }
    }
}
