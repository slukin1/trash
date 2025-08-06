package io.reactivex.rxjava3.internal.operators.flowable;

import z20.c;

public final class d<T> implements z20.d {

    /* renamed from: b  reason: collision with root package name */
    public final c<? super T> f55512b;

    /* renamed from: c  reason: collision with root package name */
    public final T f55513c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55514d;

    public d(T t11, c<? super T> cVar) {
        this.f55513c = t11;
        this.f55512b = cVar;
    }

    public void cancel() {
    }

    public void request(long j11) {
        if (j11 > 0 && !this.f55514d) {
            this.f55514d = true;
            c<? super T> cVar = this.f55512b;
            cVar.onNext(this.f55513c);
            cVar.onComplete();
        }
    }
}
